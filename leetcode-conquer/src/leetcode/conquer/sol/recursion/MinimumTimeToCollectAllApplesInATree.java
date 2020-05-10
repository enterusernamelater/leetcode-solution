package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {
	
	public MinimumTimeToCollectAllApplesInATree() {}
	
    private int res = 0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        
        for(int[] val : edges){
            list.get(val[0]).add(val[1]);
            list.get(val[1]).add(val[0]);
        }
    
        helper(list, new int[n], 0,hasApple);
        return res;
    }
    
    private boolean helper(List<List<Integer>> list, int[] v, int n, List<Boolean> hasApple){
        if(v[n] == 1) return false;
        boolean found = hasApple.get(n);
        
        List<Integer> arr = list.get(n);
        v[n] = 1;// visiting
        for(int val : arr){
            res++;
            if(helper(list,v, val, hasApple)){
                res++;
                found = true;
            }
            else res--;
            
        }
        
        return found;
    }
}
