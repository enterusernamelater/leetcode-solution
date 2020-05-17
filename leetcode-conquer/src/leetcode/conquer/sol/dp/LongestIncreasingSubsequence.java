package leetcode.conquer.sol.dp;

/*
 * a dp sol that goes back of the array on every index look for a smaller val and update
 * its own dp val to be either the val its self or the smaller val's dp +1 
 * dp[i] = Math.max(dp[i],dp[j]+1);
 * Time O(n^2) Space O(n)
 * this is basically the solution for RussianDollEnvelopes
 */
public class LongestIncreasingSubsequence {
	public LongestIncreasingSubsequence() {}
	
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        for(int val : dp) res = Math.max(res,val);
        
        return res;
    }
}
