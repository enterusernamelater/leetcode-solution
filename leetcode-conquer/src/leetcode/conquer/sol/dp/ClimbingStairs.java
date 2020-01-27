package leetcode.conquer.sol.dp;

/*
 * time O(n) space O(1)
 * a detailed explanation on this question can be found in this video
 * https://www.youtube.com/watch?v=LpsDWvkd-4Q
 */
public class ClimbingStairs {
	
	public ClimbingStairs() {}
	
    public int climbStairs(int n) {
        int cur = 1;
        int prev = 1;

        for(int i=2; i<=n;i++){
            int tmp = cur;
            cur = cur + prev;
            prev = tmp;
        }
        
        return cur;
    }
    
    public int climbStairsDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1; 
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}
