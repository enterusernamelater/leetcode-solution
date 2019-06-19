package leetcode.conquer.sol.recursion;

/*
 * this is a recursive sol but can be optimized with a memorization or dp
 * combination complexity Time o(2^n) space o(n) for the depth of recursion although at the end 
 * the recursion cleans its self up when returning
 */
public class TargetSum {
	private int res =0;
	public TargetSum() {}
	
    public int findTargetSumWays(int[] nums, int s) {
        helper(nums,s,0,0);
        return res;
    }
    
    private void helper(int[] nums, int s, int cur, int pos){
        if(cur == s && pos == nums.length){
            res++;
            return;
        }
        if(pos==nums.length) return;
        
        helper(nums,s,cur+nums[pos],pos+1);
        helper(nums,s,cur-nums[pos],pos+1);
    }
}
