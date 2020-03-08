package leetcode.conquer.sol.array;

import java.util.HashSet;
import java.util.Set;
//Time O(n) Space O(n)
public class ContainsDuplicate {
	public ContainsDuplicate() {}
	
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums) 
            if(!set.add(val)) return true; //set return false as no need to add already in it
        
        return false;
    }
}
