package leetcode.conquer.sol.dp;

import java.util.Arrays;

/*
 * the idea behind this solution is using the dp array and keep the longest subsequence range
 * only update result when the arr hits the new max length.
 * the dp array changes through us calling the arrays.binarysearch. when binarysearch returns a index that will
 * increase our current longest subsequence range we update the result
 * binarysearch returns actual index when a num is found
 * binarysearch returns negative values when a num needs to be insert. for detail check the java doc
 * Time O(nLog(n)) Space O(n)
 */
public class LongestIncreasingSubsequenceBinarySearchSol {
	public LongestIncreasingSubsequenceBinarySearchSol() {}
	
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums){
            int index = Arrays.binarySearch(dp,0,len,num);
            
            if(index < 0) index = -(index + 1);
            dp[index] = num;
            //only update len if the num we search in the binary search is largest.
            if(index == len) len++;
        }
        return len;
    }
}
