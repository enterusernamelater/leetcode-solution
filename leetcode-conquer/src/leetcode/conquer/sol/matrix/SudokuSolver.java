package leetcode.conquer.sol.matrix;

/*
 * The idea of this solution is on each available index we only place a valid number and backtracking if we encounter false 
 * until we reach to the end we return true.
 * Time is constant since the board is fixed
 * Space is constant as well.
 * the link that explains this question is below:
 * https://www.youtube.com/watch?v=JzONv5kaPJM
 */
public class SudokuSolver {
	public SudokuSolver() {}

	private int n;
	private int m;
	private char[][] board;
	private char skip;

	public void solveSudoku(char[][] board) {
		if(board == null || board.length == 0) return;

		this.n = board[0].length;
		this.m = board.length;
		this.board = board;
		this.skip = '.';
		helper(0,0);
	}

	private boolean helper(int row, int col){
		if(row == m) return true;

		if(col == n){
			return helper(row + 1, 0);
		}

		if(board[row][col] != skip){
			return helper(row, col + 1);
		}

		for(int i=1;i<=9;i++){
			if(canPlace(i, row, col)){
				char val = (char)(i + '0');
				board[row][col] = val;
				if(helper(row,col+1)) return true;
				board[row][col] = skip;
			}
		}

		return false;
	}

	private boolean canPlace(int val, int row, int col){
		for(int i=0;i<9;i++){
			if(board[row][i] != skip && board[row][i] - '0' == val) return false;
		}

		for(int i=0;i<9;i++){
			if(board[i][col] != skip && board[i][col] - '0' == val) return false;
		}

		//determine which box in a 3x3 matrix that has 3x3 box
		int rowb = (row/3 + 1)*3;
		int colb = (col/3 + 1)*3;

		for(int i=rowb-1; i>=rowb-3; i--){
			for(int j=colb-1; j>=colb-3; j--){
				if(board[i][j] != skip && board[i][j] - '0' == val) return false;
			}
		}

		return true;
	}
}
