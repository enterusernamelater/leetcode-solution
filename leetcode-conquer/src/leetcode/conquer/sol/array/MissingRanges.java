package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * sort, overcome the overflow by converting all givens to long
 * then find the missing range in between the indexs;
 * Time O(nlog(n))
 * Space constant
 */
public class MissingRanges {
	public MissingRanges() {}
	
	public List<String> findMissingRanges(int[] nums, int a, int b) {
		long lower = a;
		long upper = b;
		if(nums == null || nums.length == 0) return new ArrayList<>(Arrays.asList(lower == upper? String.valueOf(lower) : lower+"->"+upper));
		Arrays.sort(nums);

		List<String> res = new ArrayList<>();
		long val = nums[0];
		if(val - lower == 1){
			res.add(String.valueOf(lower));
		}else if(val - lower > 1){
			res.add(lower + "->" + (nums[0]-1));
		}

		for(int i=1;i<nums.length;i++){
			long val1 = nums[i], val2=nums[i-1];
			if(val1 - val2 == 2) res.add(String.valueOf(nums[i-1] + 1));
			else if(val1 - val2 > 1) res.add(nums[i-1] + 1 + "->" + (nums[i]-1));
		}

		val = nums[nums.length-1];
		if(upper-val == 1){
			res.add(String.valueOf(upper));
		}else if(upper-val > 1){
			res.add(nums[nums.length-1] + 1 + "->" + upper);
		}
		return res;
	}
}
