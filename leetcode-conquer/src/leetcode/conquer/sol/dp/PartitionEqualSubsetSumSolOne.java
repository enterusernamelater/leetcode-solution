package leetcode.conquer.sol.dp;

/*
 * a very similar solution to knapsack problem using a two dimension array
 * the idea of this solution is we find if values in the arr can reach its sum/2
 * if so the the partition is found
 * we build the dp[][] from 1 to sum/2 and each transition case can either  pick the previous 
 * number i-1 to see if the sum j is reached dp[i-1][j] is true or if we add the current number nums[i-1]
 * see if previous number with previous sum is true dp[i-1][j-nums[i]] either one of them is true
 * then the sum j is reached. until the end we will know if dp[nums.length][sum/2] can be found thru the dp[][]
 * Time o(n*sum) space O(n*sum)
 */
public class PartitionEqualSubsetSumSolOne {
	public PartitionEqualSubsetSumSolOne() {}
	
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return true;
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        
        if(sum%2 == 1) return false;
        
        int n = nums.length;
        sum /=2;
        
        boolean[][] dp = new boolean[n+1][sum+1];
        
        for(int i=0;i<=nums.length;i++) dp[i][0] = true;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
