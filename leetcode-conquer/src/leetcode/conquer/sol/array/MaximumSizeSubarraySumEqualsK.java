package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.Map;

/*
 * use a hashmap finding the difference between total range and k range
 * if the difference exists then we have found the interval
 * Time O(n)
 * Space O(n)
 * 
 */
public class MaximumSizeSubarraySumEqualsK {
	public MaximumSizeSubarraySumEqualsK() {}
	
    public int maxSubArrayLen(int[] nums, int k) {
        int[] sums = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            sums[i] = sums[i-1]+nums[i-1];
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<sums.length;i++){
            if(map.containsKey(sums[i] - k)) res = Math.max(res, i-map.get(sums[i] - k));
            map.putIfAbsent(sums[i],i); //this will maintain the longest subarray because the sums[i] is the shortest
        }
        
        return res;
    }
}
