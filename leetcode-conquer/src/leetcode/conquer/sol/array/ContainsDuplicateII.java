package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * two sols one using sliding window,another one uses hashmap
 * Time o(n) space o(n)
 */
public class ContainsDuplicateII {
	public ContainsDuplicateII() {}
	
    //sliding window approach
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(j-i+1 > k + 1) set.remove(nums[i++]);
            if(!set.add(nums[j])) return true;
        }
        
        return false;
    }
    
    //HashMap approach
    public boolean containsNearbyDuplicateHM(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int j=0;j<nums.length;j++){
            if(map.containsKey(nums[j])){
                int i = map.get(nums[j]);
                if(Math.abs(j-i) <= k) return true;
            }
            
            map.put(nums[j],j);
        }
        
        return false;
    }
}
