package leetcode.conquer.sol.rand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
 * a better solution than mine because no workload in the constractor
 * when picking random, we loop through the given arr finding all the dups index and store them in the List
 * and return a random index from the list by using rand.nextInt(list.size())
 * Time O(n) Space O(N)
 */
public class RandomPickIndex {
	List<Integer> arr;
	int[] nums;
	private Random rand = new Random();

	public RandomPickIndex(int[] nums) {
		this.nums = nums;
	}

	public int pick(int target) {
		this.arr = new ArrayList<>();

		for(int i=0;i<nums.length;i++){
			if(nums[i] == target){
				arr.add(i);
			}
		}

		return arr.get(rand.nextInt(arr.size()));
	}
}
