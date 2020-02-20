package leetcode.conquer.sol.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
	public LongestConsecutiveSequence() {}
	
	/*
	 * sort, then just count 
	 * Time O(nlogn)
	 * Space constant
	 */
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(i+1 < nums.length && nums[i] == nums[i+1]) continue;
			else if(i+1 < nums.length && nums[i+1] - nums[i] == 1) count++;
			else count = 1;
            
            res = Math.max(res,count);
        }
        
        return res;
    }
    
    /*
     * constant time complexity solution where we use the set to count the number of consecutive sequences once the first val of a sequences is found 
     * see comment below
     * 
     * Time O(n)
     * Space O(n)
     */
    public int longestConsecutiveSolTwo(int[] nums) {
        int res = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for(int i=0;i<nums.length;i++){
			//now we know this is a starting number because set does not contain its previous vals
            if(!set.contains(nums[i] - 1)){
				int count = 1;
                //once we know the starting we now just counts the number of following consecutives as long as they are in the set
				while(set.contains(nums[i]+count)) count++;
				
				res = Math.max(res,count);
			}
        }
        return res;
    }
}
