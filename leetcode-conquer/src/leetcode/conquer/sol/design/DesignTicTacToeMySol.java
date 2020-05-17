package leetcode.conquer.sol.design;

public class DesignTicTacToeMySol {	
	  /** Initialize your data structure here. */
    int[][] board;
    int[][] dp;
    int n;
    public DesignTicTacToeMySol(int n) {
        this.board = new int[n][n];
        this.dp = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int i, int j, int player) {
        int count = 0;
        board[i][j] = player;
        for(int s=i;s>=0 && board[s][j] == player;s--) count++; 
        if(count >=n) return player;
        count--;
        for(int e=i; e<n && board[e][j] == player;e++) count++;    
        if(count >=n) return player;
        
        count = 0;
        for(int s=j;s>=0 && board[i][s] == player;s--) count++; 
        if(count >=n) return player;
        count--;
        for(int e=j; e<n && board[i][e] == player;e++) count++;    
        if(count >=n) return player;
        
        count = 0;
        for(int s=i,e=j; s>=0 && e>=0 && board[s][e] == player; s--,e--) count++; 
        if(count >=n) return player;
        count--;
        for(int s=i,e=j; s<n && e<n && board[s][e] == player; s++,e++) count++; 
        if(count >=n) return player;
        
        count = 0;
        for(int s=i,e=j; s>=0 && e<n && board[s][e] == player; s--,e++) count++; 
        if(count >=n) return player;
        count--;
        for(int s=i,e=j; s<n && e>=0 && board[s][e] == player; s++,e--) count++; 
        if(count >=n) return player;
        
        return 0;
    }
}
