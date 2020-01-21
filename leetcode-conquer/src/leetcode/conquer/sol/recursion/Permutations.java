package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * permutation order matters. therefore in the backtracking we can re-use index from the beginning to the end of the array 
 * as long as they are not used in the current section of the backtracking, 
 * so that we dont get duplicate results, each index to product the result can only be used once.
 * we use a used arr to keep track wats used during back tracking 
 * time O(n!)
 * space O(n)
 * 
 */
public class Permutations {
	public Permutations() {}
	
	private List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
		if(nums == null || nums.length == 0) return res;
		boolean[] used = new boolean[nums.length];
		helper(nums,nums.length,new ArrayList<>(),used);

		return res;
	}

	private void helper(int[] nums, int n, List<Integer> arr, boolean[] used){
		if(n==0){
			res.add(new ArrayList<>(arr));
			return;
		}

		if(n<0) return;

		for(int i=0; i<nums.length;i++){
			if(used[i]) continue;
			used[i] = true;
			arr.add(nums[i]);
			helper(nums,n-1,arr,used);
			arr.remove(arr.size()-1);
			used[i] = false;
		}
	}
}
