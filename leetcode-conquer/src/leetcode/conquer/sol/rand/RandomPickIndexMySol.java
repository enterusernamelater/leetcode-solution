package leetcode.conquer.sol.rand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * my idea is to store all num's index into a map in a list
 * so when pick we just get a random index on that number's list
 * Time O(n) space O(n)
 */
public class RandomPickIndexMySol {
	private Map<Integer,List<Integer>> map = new HashMap<>();

	private Random rand = new Random();

	public RandomPickIndexMySol(int[] nums) {
		for(int i=0;i<nums.length;i++){
			List<Integer> arr = this.map.getOrDefault(nums[i], new ArrayList<>());
			arr.add(i);
			this.map.putIfAbsent(nums[i],arr);
		}
	}

	public int pick(int target) {
		List<Integer> arr = this.map.get(target);
		return arr.get(rand.nextInt(arr.size()));
	}
}
