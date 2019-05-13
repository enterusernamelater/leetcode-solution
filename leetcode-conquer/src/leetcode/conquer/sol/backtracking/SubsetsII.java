package leetcode.conquer.sol.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * very similar question to Subsets, need to sort the array to avoid dups. 
 * refer to subsets for the detailed explanation.
 * time o(n*2^n), space o(2^n)
 */
public class SubsetsII {
	
	public SubsetsII() {}
	
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++)
            helper(nums,i,0,new ArrayList<>());
        return res;
    }
    
    void helper(int[] nums, int size, int start, List<Integer> arr){
        if(arr.size()==size){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=start;i<=nums.length-size+arr.size();i++){
        	//to avoid dups.
            if(i>start && nums[i]==nums[i-1]) continue;
            arr.add(nums[i]);
            helper(nums, size, i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
