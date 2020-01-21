package leetcode.conquer.sol.array;

/*
 * logic behind this question is distance keeps expand until no more expansion 
 * in the end see if the distance reaches the last index of the array if so return true
 * otherwise false.
 * Time O(n)
 * Space constant;
 */
public class JumpGame {
	public JumpGame() {}

	public boolean canJump(int[] nums) {
		int distance = 0;

		for(int i=0;i<=distance;i++){
			distance = Math.max(distance,nums[i]+i);
			if(distance >= nums.length - 1) return true;
		}

		return false;        
	}
}
