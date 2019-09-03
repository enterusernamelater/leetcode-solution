package leetcode.conquer.sol.design;

/*
 * This is my solution, we first calculate the sum on each index store them into an sums array
 * just do the difference when getting the range sum
 * for update the index we update the index for the val and for the sums arr we add the difference from 
 * now to the end 
 * Time O(n) Space O(n)
 */
public class RangeSumQueryMutableMySol {
	public RangeSumQueryMutableMySol() {}
	
	private int[] nums;
    private int[] sums;
    public RangeSumQueryMutableMySol(int[] nums) {
        if(nums.length == 0) return;
        this.nums = nums;
        
        this.sums = new int[nums.length];
        
        sums[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sums[i] = nums[i] + sums[i-1];
        }
    }
    
    public void update(int idx, int val) {
        int diff = val - nums[idx];
        nums[idx] = val;
        
        for(int i=idx;i<nums.length;i++){
            sums[i]+=diff;
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return sums[j];
        return sums[j] - sums[i-1];
    }
}
