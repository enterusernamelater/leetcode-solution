package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Slow but works.lol
 * same as finding all permutation 
 * time o(n*n!), space o(k*n)
 */
public class PermutationSequenceMySol {
    List<List<Integer>> res = new ArrayList<>();
    public String getPermutation(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        boolean[] bool = new boolean[n];
        for(int i=1;i<=n;i++)
            arr.add(i);
        
        helper(arr,bool,new ArrayList<>(),k);
        
        arr = res.get(k-1);
        StringBuilder sb = new StringBuilder("");
        for(Integer i : arr)       
            sb.append(String.valueOf(i));
        
        return sb.toString();
    }
    
    void helper(List<Integer> nums, boolean[] bool, List<Integer> arr, int k){
        if(res.size() == k) return;
        if(arr.size() == nums.size()){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i = 0;i<nums.size();i++){
            if(bool[i] == true) continue;
            arr.add(nums.get(i)); bool[i] = true;
            helper(nums,bool,arr,k);
            arr.remove(arr.size()-1); bool[i] = false;
        }
    }

}
