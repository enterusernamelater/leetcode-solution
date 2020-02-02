package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * sort the map.values() desc order then simpily check for the starting if map val is greater than half of the arr
 * if not we add the val to a count and cotinue while keeping a count;
 * Time O(nlog(n)
 * Space O(n)
 */
public class ReduceArraySizeToTheHalf {
    public ReduceArraySizeToTheHalf() {}
    
    public int minSetSize(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int val : arr) map.put(val,map.getOrDefault(val,0)+1);
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list,(a,b)->b-a);
        
        int res = 1;
        int count = 0;
        for(int val : list){
            count+=val;
            if(count*2 < n) res++;
            else
                break;
        }
            
        return res;
    }
}
