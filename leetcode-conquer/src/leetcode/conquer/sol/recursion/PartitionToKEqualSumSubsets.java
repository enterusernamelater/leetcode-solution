package leetcode.conquer.sol.recursion;

/*
 * this is a combination backtracking approach with all elememts in the array can only be used once
 * there for need to use an arr used[] to keep track.
 * Time complexity rough to O(k*2^n) space complexity is O(n)
 * linked tutorial
 * https://www.youtube.com/watch?v=qpgqhp_9d1s
 */

public class PartitionToKEqualSumSubsets {
	
	public PartitionToKEqualSumSubsets() {}
	
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length == 0) return true;
        
        int n = nums.length;
        int sum = 0;
        
        for(int num : nums) sum+=num;
        
        if(k == 0 || sum % k != 0) return false;
        
        return helper(nums, new boolean[n], 0, sum/k, 0, k);
    }
    
    private boolean helper(int[] nums, boolean[] used, int cur, int target, int start, int k){
        if(k == 0) return true;
        if(cur>target) return false;
        
        if(cur == target){
            return helper(nums, used, 0 , target, 0, k-1);
        }
        
        for(int i=start; i<nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            if(helper(nums, used, cur+nums[i],target,i+1,k)){
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}
