package leetcode.conquer.sol.dp;

import java.util.Arrays;

/*
 * this is a improved dp solution comparing to the previous findLongestIncreasingSubsequence question
 * the key here is we need to add another dp2 arr that tracks the total number of the max sequence count.
 * we increment our current nums' dp2 if a same length is found using dp1[j] + 1 (see findLongestIncreasingSubsequence)
 * description on how this is done. if we found a larger len subsequence we reset the dp2 of the current number to the
 * dp1[j]'s dp2 
 * 
 * Time O(n^2), Space O(n)
 */
public class NumberOfLongestIncreasingSubsequence {
	public NumberOfLongestIncreasingSubsequence() {}

	public int findNumberOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		//this dp checks the number of length on each nums[i]
		int[] dp1 = new int[nums.length];
		//this dp checks the number of increase subseuqnce on each nums[i]
		int[] dp2 = new int[nums.length];

		Arrays.fill(dp1,1);
		Arrays.fill(dp2,1);
		int maxLen = 0;
		for(int i=0; i<nums.length; i++){
			for(int j=0; j<i;j++){
				if(nums[i] > nums[j]){
					if(dp1[j] + 1 > dp1[i]){
						dp1[i] = dp1[j] + 1;
						//if a bigger len of subsequence is found we reset the dp2 
						dp2[i] = dp2[j];
					}else if(dp1[j] + 1 == dp1[i]){
						//if it is the same length we increment the dp2 on the current number with dp2[j]
						dp2[i] += dp2[j];
					}

				}
			}

			maxLen = Math.max(dp1[i],maxLen);
		}

		int res = 0;
		for(int i=0; i<dp1.length; i++){
			if(dp1[i] == maxLen) res+=dp2[i];
		}

		return res;
	}
}
