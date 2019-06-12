package leetcode.conquer.sol.dp;

/*
 * a dp solution detailed explanation is below:
 * https://www.youtube.com/watch?v=KaXeidsmvVQ
 * time o(n^2), space o(n)
 */

public class PerfectSquares {
	public PerfectSquares() {}
	
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++) dp[i]=i;
        
        for(int i=1;i<=n;i++)
            for(int j=1; j*j<=i;j++)
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
        
        return dp[n];
    }
}
