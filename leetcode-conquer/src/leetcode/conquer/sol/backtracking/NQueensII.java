package leetcode.conquer.sol.backtracking;

import java.util.Arrays;

/*
 * DFS
 * this is a same sol as NQueens 1
 * just dont build the res array
 * this time is o(n!)
 * space o(n*n) for worst case
 */
public class NQueensII {
	
	public NQueensII() {}
	
    private char[][] board;
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;
    private int n;
    private int res; 
    
    public int totalNQueens(int n) {
        this.board = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],'.');
        
        this.col = new boolean[n];
        this.diag1 = new boolean[2*n-1];
        this.diag2 = new boolean[2*n-1];
        this.n = n;
        
        helper(0);
        return res;
    }
    
    private void helper(int y){
        if(y==n){
            res++;
            return;
        }
        
        for(int x=0;x<n;x++){
            if(!isAvaliable(x,y)) continue;
            updateBoard(x,y,true);
            helper(y+1);
            updateBoard(x,y,false);
        }
    }
    
    private boolean isAvaliable(int x, int y){
        return !col[x] && !diag1[x+y] && !diag2[x-y+n-1];
    }
    
    private void updateBoard(int x, int y, boolean bool){
        col[x] = bool;
        diag1[x+y] = bool;
        diag2[x-y+n-1] = bool;
        board[x][y] = bool? 'Q' : '.';
    }
}
