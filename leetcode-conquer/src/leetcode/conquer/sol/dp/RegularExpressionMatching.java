package leetcode.conquer.sol.dp;

/*
 * This is more a classic dp problem, the approach this pretty clearly stated in the video
 * link: https://www.youtube.com/watch?v=DqhPJ8MzDKM
 * Time O(nm) Space O(nm)
 * 
 * the traverse in this matrix is more a top to bottom approach than the traditional left to right
 */
public class RegularExpressionMatching {
	public RegularExpressionMatching() {}

	public boolean isMatch(String s, String p) {
		int m = p.length();
		int n = s.length();

		boolean[][] dp = new boolean[m+1][n+1];

		dp[0][0] = true;

		for(int i=1; i<=m; i++)
			if(p.charAt(i-1) == '*')
				dp[i][0] = dp[i-2][0];

		for(int j=1;j<=n;j++){
			for(int i=1;i<=m;i++){
				if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '.'){
					dp[i][j] = dp[i-1][j-1];
				}else if(p.charAt(i-1) == '*'){
					if(p.charAt(i-2) == s.charAt(j-1) || p.charAt(i-2) == '.'){
						dp[i][j] = dp[i-2][j] || dp[i][j-1];
					}else{
						dp[i][j] = dp[i-2][j];
					}
				}
			}
		}

		return dp[m][n];
	}
}
