package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * this is a similar sol to the combination sol. the idea is loop from 1...n and find the one that mods to n equals to 0
 * if is then when divide n by the factor then we again finding 1...n%i and looking for its factor. This process continues until
 * we find n==1 then we reach one result. then backtracking to find them all.
 * time o(n*2^n), space(2^n)
 */
public class FactorCombinations {
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> getFactors(int n) {
        if(n<2) return res; 
        helper(n,2,new ArrayList<>());
        return res;
    }

    private void helper(int n, int start, List<Integer> arr){
        if(n==1){
            if(arr.size()>1)
            res.add(new ArrayList<>(arr));
            return;
        }
        
        for(int i=start;i<=n;i++){
            //this means now i is one of the factor
            if(n%i == 0){
                arr.add(i);
                helper(n/i,i,arr);
                arr.remove(arr.size()-1);
            }
        }
    }
}
