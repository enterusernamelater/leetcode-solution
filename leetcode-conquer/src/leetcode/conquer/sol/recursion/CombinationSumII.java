package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * pretty much the same solution to Combination, only need to check repeat.
 * time o(n*2^n), space o(2^n)
 */
public class CombinationSumII {
	public CombinationSumII() {}
	
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length ==0 || target == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>());
        return res;
    }
    
    void helper(int[] nums, int target, int start, List<Integer> arr){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(arr));
        }
        
        for(int i=start;i<nums.length && target>=nums[i];i++){
        	//skip repeats
            if(i>start && nums[i]==nums[i-1]) continue;
            arr.add(nums[i]);
            helper(nums,target-nums[i],i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
