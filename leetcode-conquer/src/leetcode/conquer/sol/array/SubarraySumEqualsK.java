package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.Map;

/*
 * basically a two sum soltuion but using in an array where A-B=K so A-K = B we store B
 * A being array 0 to i-1 B being array 0 to j
 * Time O(n)
 * Space constant
 */
public class SubarraySumEqualsK {
	public SubarraySumEqualsK() {}
	
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            res+=map.getOrDefault(sum-k,0);
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return res;
    }
}
