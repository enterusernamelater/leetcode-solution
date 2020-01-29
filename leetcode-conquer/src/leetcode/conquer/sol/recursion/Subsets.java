package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * This is a backtracking solution that follows the solution on this link:
 * https://www.youtube.com/watch?v=CUzm-buvH_8
 * the idea is a backtracking the size variable and increment the size from 1...n until we find all the result.
 * time o(n*2^n) the reason is we need 2^n-1 for all possible combinations (for permutation is n!) and worst case the combination requires
 * an o(n) traverse.
 * space is obvious o(2^n)
 */
public class Subsets {
	List<List<Integer>> res = new ArrayList<>();
	
	public Subsets() {}
	
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        for(int i=0;i<=nums.length;i++)
            helper(nums, i, 0, new ArrayList<>());
        
        return res;
    }
    
    void helper(int[] nums, int size, int start, List<Integer> arr){
        if(arr.size()==size){
            res.add(new ArrayList<>(arr));
            return;
        }
        
        /*
         * the nums.length-size+arr.size() is the same as nums.length-(size-arr.size()) 
         * is a dp way of locking the index to the last needed position to achieve arr.size() == size
         */
        for(int i =start; i<=nums.length-size+arr.size(); i++){
            arr.add(nums[i]);
            helper(nums,size,i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
    
    private int[] nums;
    //my combination solution
    public List<List<Integer>> subsetsMySol(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        this.nums = nums;
        helper(0,new ArrayList<>());
        return res;
    }
    
    private void helper(int index, List<Integer> arr){
        res.add(new ArrayList<>(arr));
        
        for(int i=index;i<nums.length;i++){
            arr.add(nums[i]);
            helper(i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
