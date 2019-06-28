package leetcode.conquer.sol.dp;

/*
 * a dp solution that first calculate all sum index into a dp matrix 
 * then we follow the same logic as range sum query immutable to find the range sum
 * by cutting off the no-need range from the dp array
 * keep in mind that extra cuts in dp will need to be re-added back;
 * Time O(h*w) Space O(h*w)
 */
public class RangeSumQuery2DImmutable {

	private NumMatrix numMatrix;

	public RangeSumQuery2DImmutable(int[][] matrix) {
		this.numMatrix = new NumMatrix(matrix);
	}

	public NumMatrix getNumMatrix() {
		return numMatrix;
	}

	public void setNumMatrix(NumMatrix numMatrix) {
		this.numMatrix = numMatrix;
	}

	class NumMatrix {
		private int[][] dp;
		public NumMatrix(int[][] matrix) {
			if(matrix == null || matrix.length == 0) return;
			int h = matrix.length;
			int w = matrix[0].length;
			this.dp = new int[h+1][w+1];

			for(int i=1;i<=h;i++){
				for(int j=1;j<=w;j++){
					dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1]-dp[i-1][j-1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if(dp == null || dp.length == 0) return 0;
			return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
		}
	}
}
