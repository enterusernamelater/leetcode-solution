package leetcode.conquer.sol.recursion;

/*
 * the solution two minimize the sol one so that we dont need the var turn
 * to switch between players at the end of the day all we need to do is 
 * for each layer we keep a minimal difference between two players' delta score when negative
 * and maximize the score between two players' delta score when positive.
 * also a map to skip any duplicate pairs for left and right
 * 
 *  Time O(2^n) Space O(n^2)
 */
public class PredictTheWinnerSolTwo {
	public PredictTheWinnerSolTwo() {}
	
    private Integer[][] map;
    public boolean PredictTheWinner(int[] nums) {
        this.map = new Integer[nums.length][nums.length];
        return helper(nums,0,nums.length-1) >=0;   
        
    }
    
    private int helper(int[] nums, int left, int right){
        if(left == right) return nums[left];
        
        if(map[left][right] != null) return map[left][right]; 
        
        int a = nums[left]  - helper(nums,left+1,right);
        int b = nums[right]  - helper(nums,left,right-1);
        map[left][right] = Math.max(a,b);  
        return map[left][right];  
    }
}
