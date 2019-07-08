package leetcode.conquer.sol.dp;

/*
 * same sol as the link below:
 * https://www.youtube.com/watch?v=UjiFFYU3EKM
 * i is the start j is the end.
 * Time O(n^2) Space O(n^2)
 */
public class CountDifferentPalindromicSubsequencesDPSolTwo {
	public CountDifferentPalindromicSubsequencesDPSolTwo() {}

	public int countPalindromicSubsequences(String s) {
		if(s == null || s.length() == 0) return 0;
		int n = s.length();
		int[][] dp = new int[n][n];
		int mod = 1000000007;

		for(int i=0;i<n;i++)
			dp[i][i] = 1;

		for(int len=1; len<=s.length();len++){
			for(int i=0; i<s.length()-len;i++){
				int j = i+len;
				long ans = 0;

				if(s.charAt(i) == s.charAt(j)){
					int l = i+1;
					int r = j-1;

					while(l<=r && s.charAt(i)!= s.charAt(l)) l++;
					while(l<=r && s.charAt(i)!= s.charAt(r)) r--; 

					if(l>r){
						ans = 2*dp[i+1][j-1] + 2;
					}else if(l == r){
						ans = 2*dp[i+1][j-1] + 1;
					}else{
						ans = 2*dp[i+1][j-1] - dp[l+1][r-1];
					}
				}else{
					ans = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
				}

				dp[i][j] = (int)((ans+mod)%mod);
			}
		}

		return dp[0][n-1];
	}
}
