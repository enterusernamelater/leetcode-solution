package leetcode.conquer.sol.recursion;

/*
 * Min Max Alg, a basic sol with a turn var to switch between player 1 and player 2
 * detail explanation see leetcode solution
 * 
 * Time O(2^n) Space constant
 */
public class PredictTheWinnerSolOne {	
	public PredictTheWinnerSolOne() {}
	
	public boolean PredictTheWinner(int[] nums) {
		return helper(nums,0,nums.length-1,1) >=0;   
	}

	private int helper(int[] nums, int left, int right, int turn){
		if(left == right) return turn*nums[left];
		int a = nums[left] * turn + helper(nums,left+1,right,-turn);
		int b = nums[right] * turn + helper(nums,left,right-1,-turn);
		return turn * Math.max(a*turn,b*turn);  
	}
}
