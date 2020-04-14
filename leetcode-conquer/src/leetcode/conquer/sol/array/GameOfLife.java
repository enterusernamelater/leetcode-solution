package leetcode.conquer.sol.array;

/*
 * follow the rule with a little simplified basically if live neighbor is less than 2 or greater than 3 live cell dies
 * and if live neighbor is exact 3 dead cell turn back live
 * we use int 2 as change 1 to 0 and 3 as change 0 to 1 until all board cells are changed 
 * then we loop through the board again and flip the cell to its proper value
 * this will satisfy the question's constant memeory requirement.
 * Time O(m*n)
 * Space constant
 */
public class GameOfLife {
	public GameOfLife() {}
	
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int n = board[0].length;
        int m = board.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live = 0;
                if(i-1>=0 && j-1>=0 && board[i-1][j-1] >= 1 && board[i-1][j-1]<3) live++;
                if(i-1>=0 && board[i-1][j] >= 1 && board[i-1][j] < 3) live++;
                if(i-1>=0 && j+1<n && board[i-1][j+1] >= 1 && board[i-1][j+1] < 3) live++;
                if(j-1>=0 && board[i][j-1] >= 1 && board[i][j-1] < 3) live++;
                if(j+1<n && board[i][j+1] >= 1 && board[i][j+1] < 3) live++;
                if(i+1<m && j-1>=0 && board[i+1][j-1] >= 1 && board[i+1][j-1] < 3) live++;
                if(i+1<m && board[i+1][j] >= 1 && board[i+1][j] < 3) live++;
                if(i+1<m && j+1<n && board[i+1][j+1] >= 1 && board[i+1][j+1] < 3) live++;
                if(live<2 || live>3) board[i][j] = board[i][j] == 1? 2 : 0; //2 is 1 to 0;
                else if(live == 3) board[i][j] = board[i][j] == 0? 3 : 1; //3 is 0 to 1
            }
        }
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(board[i][j]==2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
    }
}
