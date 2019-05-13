package leetcode.conquer.sol.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * this is same as the subset questions. only difference is since the size is already defined we do not need to loop 1...n size
 * time o(k*nCk) the combination formula nCk is the number of possible combinations for k, times k because each combination requires k travses.
 * space o(nCk) because there are nCk combinations 
 */
public class Combinations {
	public Combinations() {}
	
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0) return new ArrayList<>();
        
        helper(n,k,1,new ArrayList<>());
        return res;
    }
    
    void helper(int n, int size, int start, List<Integer> arr){
        if(arr.size() == size){
            res.add(new ArrayList<>(arr));
            return;
        }
        //here the plus 1 because we start from 1 to n;
        for(int i=start;i<=n-size+arr.size()+1;i++){
            arr.add(i);
            helper(n,size,i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
