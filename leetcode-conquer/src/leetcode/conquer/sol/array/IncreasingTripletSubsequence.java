package leetcode.conquer.sol.array;

/*
 * use three low points to track the lowest incrementing points.
 * if all three are found return true
 * otherwise if not found return false.
 * 
 * Time O(n)
 * Space constant
 */
public class IncreasingTripletSubsequence {
	
	public IncreasingTripletSubsequence() {}

    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 4) return false;
        Integer low1=null,low2=null,low3=null;
        
        for(int i=0; i<nums.length; i++){
            if(low1 == null || nums[i] <= low1){
                low1 = nums[i];
            }else if(low2 == null || nums[i] <= low2){
                low2 = nums[i];
            }else if(low3 == null || nums[i] <= low3){
                low3 = nums[i];
            }
        }
        
        if(low1 == null || low2 == null || low3 == null) return false;
        return true;
    }
}
