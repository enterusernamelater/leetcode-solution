package leetcode.conquer.sol.dp;

/*
 * This is a very hard dp solution..a detailed explanation vid is linked below
 * the solution is taken on the second part of the video
 * Time O(h*w), Space O(h*w)
 */
public class MaximalSquare {
	public MaximalSquare() {}
	
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0) return 0;

		int h = matrix.length;
		int w = matrix[0].length;

		int[][] dp = new int[h][w];

		int res = 0;
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				dp[i][j]=matrix[i][j]-'0';
				if(dp[i][j] == 0) continue;

				if(i != 0 && j != 0)
					dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;

				res = Math.max(res, dp[i][j]*dp[i][j]);
			}
		}

		return res;
	}
}
