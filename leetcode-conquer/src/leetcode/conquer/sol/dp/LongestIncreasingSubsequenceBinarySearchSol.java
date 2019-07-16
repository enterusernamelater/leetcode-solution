package leetcode.conquer.sol.dp;

import java.util.Arrays;

/*
 * The idea of this question is using the binarysearch method from Arrays to determine
 * the right index to enter in the dp array to insert our val. the dp array will always keep
 * the latest largest increasing subsequence because we just need to simply update the index in dp
 * based on what binarysearch method returns to us. the binarysearch method returns the largest index if 
 * no val in the array is greater than the given val. or a index that is equal to the first val's index that is
 * greater than the given val. so we can either replace a val or increment the array. everything we increment the arr
 * we increment len so at the end we just need to return the len as the result.
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
