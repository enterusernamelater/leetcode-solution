package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * very similar to the first permutation the only differnece is that we need to skip the repeat
 * we first sort the list
 * If the next number is the same as the previous, we skip if its previous has been
 * released from its recursion (free up from the its used index). 
 * we dont need to find the same permutation on a same starting number twice. 
 * Time O(n!) Space O(n)
 */
public class PermutationsII {
	public PermutationsII() {}

	private List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		if(nums == null || nums.length == 0) return res;

		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		helper(nums,nums.length,used, new ArrayList<>());
		return res;
	}

	private void helper(int[] nums, int n, boolean[] used, List<Integer> arr){
		if(n==0){
			res.add(new ArrayList<>(arr));
			return;
		}

		if(n<0) return;

		for(int i=0;i<nums.length;i++){
			if(used[i]) continue;
			//here skip if we are finding permutation on the same starting
			if(i>0 && !used[i-1] && nums[i] == nums[i-1]) continue;
			used[i]=true; arr.add(nums[i]);
			helper(nums,n-1,used,arr);
			used[i]=false; arr.remove(arr.size()-1);
		}
	}
}
