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
        	//allow i == start for cases like 1,1,6 when target is for example 8 and then skip repeats
            if(i>start && nums[i]==nums[i-1]) continue;
            arr.add(nums[i]);
            helper(nums,target-nums[i],i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
    
    private int[] candidates;
    private boolean[] used;
    private int target;
    
    public List<List<Integer>> combinationSum2SolTwo(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        this.used = new boolean[candidates.length];
        
        helper(new ArrayList<>(),0,0);
        
        return res;
    }
    
    //use an array of 'used' to keep track of what is used and to skip the repeat ones once are used
    //for cases like 1,1,6. however above solution is much more elegant. 
    private void helper(List<Integer> arr, int curr, int start){
        if(target == curr){
            res.add(new ArrayList<>(arr));
            return;
        }
        
        if(curr > target) return;
        
        for(int i=start;i<candidates.length;i++){
            if(used[i]) continue;
            if(i>0 && !used[i-1] && candidates[i] == candidates[i-1]) continue;
            used[i] = true;
            arr.add(candidates[i]);
            helper(arr, curr+candidates[i], i+1);
            arr.remove(arr.size()-1);
            used[i] = false;
        }
    }
}
