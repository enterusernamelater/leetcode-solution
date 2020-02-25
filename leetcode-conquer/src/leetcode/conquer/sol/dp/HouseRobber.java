package leetcode.conquer.sol.dp;

public class HouseRobber {
	public HouseRobber() {}

	/*
	 * as from below solution because we only care about previous and previous before previous house
	 * the dp solution can be simplified from a dp arr to dp solution with two local variables.
	 * Time O(n)
	 * Space constant 
	 */
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int p1 = 0;
		int p2 = nums[0];
		for(int i=1;i<nums.length;i++){
			int save = p2;
			p2 = Math.max(nums[i]+p1,p2);
			p1 = save;
		}

		return p2;
	}

	/*
	 * we use a dp arr to track each index's max, the max is obtained by either taking the previous neighbor meaning dont rub current index
	 * or rub the current house and the money obtained from previous before previous house
	 * Time O(n)
	 * Spce O(n)
	 */
	public int robDP(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length+1];
		dp[1] = nums[0];
		for(int i=2;i<=nums.length;i++){
			dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
		}

		return dp[nums.length];
	}
}
