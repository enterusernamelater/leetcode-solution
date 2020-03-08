package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	public ContainsDuplicateIII() {}
	
	/*
	 * bucket sort solution 中文解释 ：） 
	 * 自己想了下例子还是明白了，任何数落在t+1的自己bucket 里他们的difference abs一定小于等于t 
	 * 例如说t=3 bucket 1里的数就是 4,5,6,7 你看里面任何一个数相减的abs都是小于等于3的。 
	 * 然后再看邻居 bucket 0 里有的数在这个例子里是 0,1,2,3 那么这里面其中有些数和bucket 1里的有些数相减的 
	 * abs会小于等于t 同样的解释可以用于bucket2. bucket 3里的数为 12，13，14，15.这里的任何一个数和bucket1 
	 * 里的任意数相减都不会小于等于 t (12-7=5). 为什么+1 因为避免t=0. 
	 * 为什么减去 min:  其实这里不需要第一个loop找最小的，用integer.min_value就行。 
	 * 此用意是为了把所有负数在 k这个silding winodw里规划到他们自己的bucket里 不会和postives混合。
	 * 想这个例子，-4,3 k = 1, t=3 你就明白了， -4 和3 会进同一个bucket里 但他们的abs difference 不会小于等于3. 
	 * 当然，如果说 负数和正数的difference abs小于等于t像这样的例子 [-1,3] k=2, t=4， 
	 * 他们落入的bucket 在减去integer.min_value后也是相邻的。道理就像把-1 到 3 换成了都是正数一样， 他们的difference abs不变。
	 * Time O(n)
	 * Space O(k)
	 * 
	 */
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k<=0 || t < 0) return false;
        Map<Long,Long> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            long bucket = ((long)nums[i] - (long)Integer.MIN_VALUE)/(t+1);
            
            if(map.containsKey(bucket)) return true;
            
            Long val1 = map.get(bucket-1);
            if(val1 != null && Math.abs(val1 - (long)nums[i]) <= t) return true;
            val1 = map.get(bucket+1);
            if(val1 != null && Math.abs(val1 - (long)nums[i]) <= t) return true;
            
            map.put(bucket,(long)nums[i]);
            if(map.size()-1 == k) map.remove(((long)nums[i-k] - (long)Integer.MIN_VALUE)/(t+1));
        }
        
        return false;
    }
	
    /*
     * a tree set silding window approach that we keep a silding window on the treeset while sorts all inserts
     * and check if inserted higher and lower value difference (abs) if matches t
     * if so we have our result
     */
    public boolean containsNearbyAlmostDuplicateTreeSet(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(j-i > k) set.remove(nums[i++]);
            if(!set.add(nums[j]) && t>=0) return true;
            
            if(set.higher(nums[j]) != null && Math.abs((long)set.higher(nums[j]) - (long)nums[j]) <= t) return true;
            if(set.lower(nums[j]) != null && Math.abs((long)set.lower(nums[j]) - (long)nums[j]) <= t) return true;
        }
        
        return false;
    }
}
