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
	public NQueens() {}
    
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return res;
        boolean[] col = new boolean[n]; //isUsed
        
        //update diagl basically goes from left top to bottom right. there will be 2*n-1 of them
        //index postion of diagl will be based on i and j -> i+j
        boolean[] diagl = new boolean[n*2-1];
        //update diagr basically goes from left bottom to the top right, there will also be 2*n-1 of them
        //the index position of diagr will start at a neutral position n-1 which is the middle index
        //as i and j moves the position of diagr becomes n-1 + j - i, first half(bottom left to mid) j-i is negative
        //so n-1+j-i decreases from its neutral position n-1, second half(mid to top right) j-1 is positive,
        //so n-1+j-1 increases from its neutral position n-1.
        boolean[] diagr = new boolean[n*2-1];
        char[][] board = new char[n][n];
        
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }
        
        helper(col,diagl,diagr,0,n,board);
        return res;
    }
    
    private void helper(boolean[] col, boolean[] diagl, boolean[] diagr, int i, int n, char[][] board){
        if(i==n){
            build(board);
            return;
        }

        for(int j=0;j<n;j++){
            if(notAvailable(i,j,col,diagl,diagr)) continue;
            updateAvailable(i, j, true,col,diagl,diagr,board);
            helper(col,diagl,diagr,i+1,n,board);
            updateAvailable(i, j, false,col,diagl,diagr,board);
        }
    }
    
    private boolean notAvailable(int i, int j, boolean[] col, boolean[] diagl, boolean[] diagr){
        return col[j] || diagl[i+j] || diagr[col.length - 1 + j - i];
    }
    
    private void updateAvailable(int i, int j, boolean isUsed, boolean[] col, boolean[] diagl, boolean[] diagr, char[][] board){
        col[j] = isUsed;
        diagl[i+j] = isUsed;
        diagr[col.length - 1 + j - i] = isUsed;
        board[i][j] = isUsed? 'Q' : '.';
    }
    
    private void build(char[][] board){
        List<String> arr = new ArrayList<>();
        for(int i=0;i<board.length;i++)
            arr.add(new String(board[i]));
        
        res.add(arr);
    }
}
