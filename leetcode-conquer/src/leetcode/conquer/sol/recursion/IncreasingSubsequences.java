package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * this is a dfs recursion solution and usng a hashset to store used val for example
 * 6,7,7 in the loop at first 7 the 7 is stored in the set, so the next 7 will be skipped to prevent results
 * duplication like 6,7 and 6,7 
 * Time O(n*2^n) Space O(2^n)
 */
public class IncreasingSubsequences {
	public IncreasingSubsequences() {};
	
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length == 0) return res;
        this.nums = nums;
        
        helper(new ArrayList<>(), 0);
        return res;
    }
    
    private void helper(List<Integer> arr, int start){
        if(arr.size()>1){
            res.add(new ArrayList<>(arr));
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            if(arr.isEmpty() || arr.get(arr.size()-1) <= nums[i]){
                arr.add(nums[i]);
                set.add(nums[i]);
                helper(arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
    }
}
