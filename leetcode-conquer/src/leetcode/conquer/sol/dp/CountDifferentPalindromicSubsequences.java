package leetcode.conquer.sol.dp;

/*
 * a dp solution very similar to the solution in this link
 * https://www.youtube.com/watch?v=UjiFFYU3EKM
 * but j is the start i is the end.
 * Time O(n^2) Space O(n^2)
 */
public class CountDifferentPalindromicSubsequences {

	public CountDifferentPalindromicSubsequences() {}

	public int countPalindromicSubsequences(String s) {
		if(s == null || s.length() == 0) return 0;
		int n = s.length();
		int[][] dp = new int[n][n];
		int mod = 1000000007;

		for(int i=0; i<s.length();i++){
			for(int j=i; j>=0;j--){
				long ans = 0;
				if(i == j){
					ans = 1;
				}else{
					if(s.charAt(i) == s.charAt(j)){
						int l = j+1;
						int r = i-1;

						while(l<=r && s.charAt(i)!= s.charAt(l)) l++;
						while(l<=r && s.charAt(i)!= s.charAt(r)) r--; 

						if(l>r){
							ans = 2*dp[i-1][j+1] + 2;
						}else if(l == r){
							ans = 2*dp[i-1][j+1] + 1;
						}else{
							ans = 2*dp[i-1][j+1] - dp[r-1][l+1];
						}
					}else{
						ans = dp[i-1][j] + dp[i][j+1] - dp[i-1][j+1];
					}
				}
				dp[i][j] = (int)((ans+mod)%mod);
			}
		}

		return dp[n-1][0];
	}
}
