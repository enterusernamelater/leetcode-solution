package leetcode.conquer.sol.dp;

/*
 * this is a dp solution referring to the link below with very detailed explanation
 * https://www.youtube.com/watch?v=z3hu2Be92UA
 * I belive the time complexity is close to O(n^3)
 * where as space is O(n^2)
 */
public class BurstBalloons {
	
	public BurstBalloons() {}
	
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int n = nums.length;
        
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1] = 1;
        
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        
        int[][] dp = new int[n+2][n+2];
        
        for(int l=1; l<=n; l++){
            for(int i=1;i<=n+1-l;i++){
                int j = i+l-1;
                for(int k =i;k<=j;k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + arr[i-1]*arr[k]*arr[j+1] + dp[k+1][j]);
                }
            }
        }
        
        return dp[1][n];    
    }
}
