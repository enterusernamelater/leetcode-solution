package leetcode.conquer.sol.array;

/*
 * first we delete all duplicate ones and decrease the n every time we remove a dup
 * then we check if the difference between nums[i] - nums[i-1] actually alternates
 * if one doesn't, we decrease n again as we are remove nums[i-1] because nums[i] - nums[i-2] has to match
 * then our 'check' state stays then same and ready for the next alternate check
 * Time O(n)
 * space constant 
 */
public class WiggleSubsequence {
	public WiggleSubsequence() {}
	
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        Boolean check = null;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                n--;
                continue;
            }
            if(check != null && check == (nums[i] - nums[i-1] > 0)){
                n--;
            }
            
            check = nums[i] - nums[i-1] > 0;
        }
        
        return n;
    }
}
