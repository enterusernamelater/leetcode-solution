package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.List;

/*
 * a basic two pointer solution, checking i and i+1 index see if connected meaning nums[i]+1 == nums[i+1]
 * if not we record the previous i j range into the res as string
 * Time O(N)
 * Space constant
 */
public class SummaryRanges {
	public SummaryRanges() {}

	public List<String> summaryRanges(int[] nums) {
		int i=0;
		List<String> res = new ArrayList<>();
		for(int j=0;j<nums.length;j++){
			if((j+1 < nums.length && nums[j] + 1 != nums[j+1]) || j == nums.length-1){
				if(nums[i] != nums[j])
					res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j]));
				else
					res.add(String.valueOf(nums[i]));
				i=j+1;
			}
		}

		return res;
	}
}
