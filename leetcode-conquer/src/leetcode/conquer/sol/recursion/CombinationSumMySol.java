package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * find all combination but allow dup vals been used.
 * indexing on i allows combination not turning to permutation
 * if dont want to reuse index we can do i+1
 * Time O(2^n) Space constant
 */
public class CombinationSumMySol {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] arr;
    private int target;
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        if(arr == null || arr.length == 0) return res;
        this.arr = arr;
        this.target = target;
        
        helper(0,0,new ArrayList<>());
        
        return res;
    }
    
    private void helper(int index, int sum, List<Integer> list){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=index;i<arr.length;i++){
            list.add(arr[i]);
            helper(i,sum+arr[i],list);
            list.remove(list.size()-1);
        }
    }
}
