package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.Map;

/*
 * This is basically a two sum approach with the following property:
 * So brilliant, learned a lot. Let me "visualize" @compton_scatter 's strategy:

Running sum from first element to index i : sum_i. If we mod k, it will be some format like : sum_i = k * x + modk_1
Running sum from first element to index j : sum_j. If we mod k, it will be some format like : sum_j = k * y + modk_2
If they have the same mod, which is modk_1 == modk_2, subtracting these two running sum 
we get the difference sum_i - sum_j = (x - y) * k = constant * k, 
and the difference is the sum of elements between index i and j, and the value is a multiple of k.

 * Time O(n),
 * Space O(n)
 */
public class ContinuousSubarraySum {
	public ContinuousSubarraySum() {}
	
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(k != 0) sum%=k;
            if(map.get(sum) != null){
                if(i-map.get(sum) > 1) return true;
            }else map.put(sum,i);
        }
        
        return false;
    }
}
