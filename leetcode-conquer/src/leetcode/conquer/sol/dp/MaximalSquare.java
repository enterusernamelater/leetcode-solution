package leetcode.conquer.sol.dp;

/*
 * This is a very hard dp solution..a detailed explanation vid is linked below
 * the solution is taken on the second part of the video
 * Time O(h*w), Space O(h*w)
 */
public class MaximalSquare {
	public MaximalSquare() {}
	
	/*
	 * this dp solution calculates the max square number on each index by applying sqrt of the minimum:
	 * Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1 as plus the current index if is '1'
	 * then the current index square number becomes (Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1)^2
	 * skip when encounters 0, and using a res val to keep track the max square number
	 * Time O(n*m)
	 * Space O(n*m)
	 */
    public int maximalSquareMySol(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '0') continue;
                double val = (double)Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                val = Math.sqrt(val) + 1;
                dp[i][j] = Double.valueOf(val*val).intValue();
                res = Math.max(res,dp[i][j]);
            }
        }
        
        return res;
    }
	
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
