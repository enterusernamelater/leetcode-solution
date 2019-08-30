package leetcode.conquer.sol.design;

/*
 * The key to achieve a O(n) solution is that we only need to keep a count for each row and column. 
 * If at any time a row or column matches the size of the board then that player has won.
 * To keep track of which player, I add one for Player1 and -1 for Player2. 
 * There are two additional variables to keep track of the count of the diagonals. 
 * Each time a player places a piece we just need to check the count of that row, column, diagonal and anti-diagonal.
 * Time O(n) Space O(n)
 */
public class DesignTicTacToe {
	private int[] row;
	private int[] col;
	private int diagonal;
	private int antiDiagonal;
	private int n;
	/** Initialize your data structure here. */
	public DesignTicTacToe(int n) {
		this.row = new int[n];
		this.col = new int[n];
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
		int add = player == 1? 1 : -1;
		row[i] += add; //add counts on the row
		col[j] += add; //add counts on the col
		
		//add counts on the diagonal 
		if(i == j){
			diagonal += add;
		}
		
		//antiDiagonal is the opposite of diagonal
		if(j == (n-i-1)){
			antiDiagonal += add;
		}

		if(Math.abs(row[i]) == n || Math.abs(col[j]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) return player;

		return 0;
	}
}
