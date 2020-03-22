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
            //this means now i is one of the factor, you cant have a n/i that results decimal makes no sense. 
            if(n%i == 0){
                arr.add(i);
                helper(n/i,i,arr);
                arr.remove(arr.size()-1);
                if(n/i < 1) return; // we stop when first n/i < 1 occurs because i always increments and will from now on always equal to less than 1
            }
        }
    }
    
    
    /*
     * beats only 5% :(.. the above solution is much faster because of less recursion loops occurs using division than multiplication
     * the loop limit in above solution is n, and n updates to n/i each time a candiate i is found this dramatically reduces
     * the number of loop occurrences as well as the length of the loop. so each loop doesn't have to be n/2 long.
     * 
     */
    public List<List<Integer>> getFactorsMySol(int n) {
        helper(n,1,new ArrayList<>(),2);
        return res.isEmpty() || res.get(0).isEmpty()? new ArrayList<>() : res;
    }
    
    private void helper(int n, long curr, List<Integer> list, int val){
        if(curr == n){
            res.add(new ArrayList<>(list));
            return;
        }
        if(curr > n) return;
        
        for(int i=val;i<=n/2;i++){
            if(n%i != 0) continue;
            list.add(i);
            helper(n,curr*i,list,i);
            list.remove(list.size()-1);
            if(curr*i > n) return;
        }
    }
}
