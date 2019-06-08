package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * DFS
 * permutation complexity
 * time o(n!) space o(n*n);
 * the hard part about this question is to find all the conditions row, col and diagonals 
 * in order to find the available positions
 * once the conditions are out this is just a backtracking on a 2d board. 
 * base case is when y reaches to the same as n then we know we found the right board.
 * link for sol:
 * https://www.youtube.com/watch?v=Xa-yETqFNEQ
 */
public class NQueens {
	private List<List<String>> res = new ArrayList<>();
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;
    private char[][] board;
    
	public NQueens() {}
    
    public List<List<String>> solveNQueens(int n) {
        this.board = new char[n][n];
        
        for(int i=0; i<n; i++)
            Arrays.fill(board[i],'.');
        
        //this is where we defined the conditions.
        this.col = new boolean[n];
        this.diag1 = new boolean[2*n-1];
        this.diag2 = new boolean[2*n-1];
        
        helper(0,n);
        
        return res;
    }
    
    private void helper(int y, int n){
        if(y == n){
            res.add(construct());
            return;
        }
        
        for(int x=0; x<n;x++){
            if(!isAvailable(x,y,n)) continue;
            updateBoard(true,x,y,n);
            helper(y+1,n);
            updateBoard(false,x,y,n);
        }
    }
    
    private void updateBoard(boolean isUsed, int x, int y, int n){
        col[x] = isUsed;
        diag1[x+y] = isUsed;
        diag2[x-y+n-1] = isUsed;
        board[x][y] = isUsed? 'Q' : '.';
    }
    
    private boolean isAvailable(int x, int y, int n){
        return !col[x]&&!diag1[x+y]&&!diag2[x-y+n-1];
    }
    
    private List<String> construct(){
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++)
            res.add(String.valueOf(board[i]));
        return res;
    }
}
