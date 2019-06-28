package leetcode.conquer.sol.dp;


/*
 * A dp solution that we store all results on each index of the nums array to a dp array
 * and later if we want to find the index i j sub sum we just simpily perfom dp[j+1] - dp[i] to find the sub sum
 * Time O(n) Space O(n)
 */
public class RangeSumQueryImmutable {

	private NumArray numArray;

	public RangeSumQueryImmutable(int[] nums) {
		this.numArray = new NumArray(nums);
	}

	public NumArray getNumArray() {
		return numArray;
	}

	public void setNumArray(NumArray numArray) {
		this.numArray = numArray;
	}

	class NumArray {
		private int[] dp;
		public NumArray(int[] nums) {
			this.dp = new int[nums.length+1];
			dp[0] = 0;
			for(int i = 1; i<=nums.length; i++){
				dp[i] = dp[i-1]+nums[i-1];
			}
		}

		public int sumRange(int i, int j) {
			return dp[j+1]-dp[i];
		}
	}
}
