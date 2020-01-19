package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * this question still follows the same logic as the other combination,subset questions. 
 * time o(9*2^9) for the worst case, since we need to use 1....9 numbers to find sum
 * space o(2^9) for the worst case
 */
public class CombinationSumIII {	
	public CombinationSumIII() {}
	
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n == 0) return res;
        
        helper(k,n,1,new ArrayList<>());
        return res;
    }
    
    void helper(int k, int target,int start, List<Integer> arr){
        if(target == 0 && arr.size() == k){
            res.add(new ArrayList<>(arr));
            return;
        }
        
        if(arr.size()>=k) return;
        
        for(int i=start; i<=9 && target>=i;i++){
            arr.add(i);
            helper(k,target-i,i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum3SolTwo(int k, int n) {
        if(k == 0) return new ArrayList<>();
        
        helperSolTwo(k, n, 1, new ArrayList<>());
        return res;
    }
    
    private void helperSolTwo(int k, int n, int start, List<Integer> arr){
        if(n==0 && k == 0){
            res.add(new ArrayList<>(arr));
            return;
        }
        
        if(k < 0 || n < 0) return;
        
        for(int i=start;i<=9;i++){
            arr.add(i);
            helper(k-1,n-i,i+1, arr);
            arr.remove(arr.size()-1);
        }
        
    }
}
