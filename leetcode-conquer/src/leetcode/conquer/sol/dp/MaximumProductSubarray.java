package leetcode.conquer.sol.dp;

public class MaximumProductSubarray {
	public MaximumProductSubarray() {}
	
	/*
	 * from the dp solution below, since we only care about dp[i-1] therefore we can now make the solution memeory space constant
	 * here is an explanation from leetcode:
	 * at each new element, u could either add the new element to the existing product, 
	 * or start fresh the product from current index (wipe out previous results), 
	 * hence the 2 Math.max() lines. if we see a negative number
	 * Time O(n)
	 * Space constant
	 */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp = max;
            max = Math.max(Math.max(min*nums[i],max*nums[i]),nums[i]);
            min = Math.min(Math.min(min*nums[i],tmp*nums[i]),nums[i]);

            res = Math.max(res,max);
        }
        
        return res;
    }

	/*
	 * The interesting thing about this solution is that it depends not only on a state 
	 * (the largest product that can be obtained by a sequence ending in the previous number), 
	 * but two states (the largest and smallest products). A simpler dp problem might just create a 
	 * dp[] and put the maximum value in it(in this case, the largest product). 
	 * But this solution show us a new way: Our dp array can store more data than just a single value. 
	 * The reason why the above solution does not use the dp array is that dp[i] only depends on dp[i - 1] 
	 * so there is no need to save all the previous max and min data, just save the previous max and min value(dp[i - 1]). 
	 * The following code uses the custom inner class Tuple so that both imax and imin can be stored, 
	 * and all imax and imin are stored in the dp array. Although it is a bit more complicated, 
	 * it helps to deepen understanding.
	 * 
	 * Time O(n)
	 * Space O(n)
	 */
	public int maxProductDP(int[] nums) {
		Value[] dp = new Value[nums.length];
		dp[0] = new Value(nums[0],nums[0]);
		int res = nums[0];
		for(int i=1;i<nums.length;i++){
			Value prev = dp[i-1];
			int max = Math.max(Math.max(prev.min*nums[i],prev.max*nums[i]),nums[i]);
			int min = Math.min(Math.min(prev.min*nums[i],prev.max*nums[i]),nums[i]);
			dp[i] = new Value(max,min);
			res = Math.max(res,max);
		}

		return res;
	}
}

class Value{
	public int max;
	public int min;

	public Value(int max, int min){
		this.max = max;
		this.min = min;
	}
}
