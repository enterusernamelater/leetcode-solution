package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.List;

/*
 * two pointer i j forms sliding window when sum is greater than s we drop the last in the silding window 
 * see if the sum still greater. while keeping track of the min size.
 * sliding window grows when sum is less than s
 * O(n)
 * Space constant
 */
public class MinimumSizeSubarraySum {
	public MinimumSizeSubarraySum() {}
	
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int i=0;
        int sum = 0;
        
        for(int j=0; j<nums.length; j++){
            sum+=nums[j];
            while(sum >= s){
                res = Math.min(res,j-i+1);
                sum-=nums[i++];
            }
        }

        return res == Integer.MAX_VALUE? 0 : res;
    }
}
