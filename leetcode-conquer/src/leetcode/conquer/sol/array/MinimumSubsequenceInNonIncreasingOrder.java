package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * sort the given arr in a list in descent order. then
 * add from the beginning once the sum passes the half of the array total sum we return
 * as now we know the result is the biggest you will get
 * Time O(nlogn)
 * Space O(n)
 */
public class MinimumSubsequenceInNonIncreasingOrder {
	public MinimumSubsequenceInNonIncreasingOrder() {}
	
    public List<Integer> minSubsequence(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int max = 0;
        
        for(int val : nums){
            max+=val;
            list.add(val);
        }
        
        Collections.sort(list,(a,b) -> b - a);
        int sum =0;
        for(int i=0;i<nums.length && sum <= max/2;i++){
            sum+=list.get(i);
            res.add(list.get(i));
        }
        
        return res;
    }
}
