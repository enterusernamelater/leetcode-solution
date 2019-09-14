package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.Map;

/*
 * This is classic, use a map to store nums and index and see if a compliment match in the map
 * Time O(n) Space O(n)
 */
public class TwoSum {
	public TwoSum() {}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
			map.put(nums[i],i);
		}
		return new int[]{};
	}
}
