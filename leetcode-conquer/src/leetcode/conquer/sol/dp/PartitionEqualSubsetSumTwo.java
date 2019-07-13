package leetcode.conquer.sol.dp;

/*
 * a simplified sol based on sol one. the difference is that we cannot start from 1 to sum because when 1 is sum the sum arr will be filled with true
 * we need to start from sum and to 1
 * 
 * Time(n*s) space O(s)
 */
public class PartitionEqualSubsetSumTwo {
	public PartitionEqualSubsetSumTwo() {}
	
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return true;
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        
        if(sum%2 == 1) return false;
        
        sum /=2;
        
        boolean[] dp = new boolean[sum+1];
        
        dp[0] = true;
        
        for(int num : nums){
            for(int j=sum;j>0;j--){
                if(num <= j){
                    dp[j] = dp[j] || dp[j-num];
                }
            }
        }
        return dp[sum];
    }
}
