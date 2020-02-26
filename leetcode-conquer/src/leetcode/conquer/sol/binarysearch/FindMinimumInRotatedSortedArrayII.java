package leetcode.conquer.sol.binarysearch;

/*
 * basically a same solution as its previous. only difference is that we need to skip the repeats.
 * since we are skipping the repeats the time now is O(n) thinking about the worst case were all vals are the same
 * Space O(1)
 */
public class FindMinimumInRotatedSortedArrayII {
	public FindMinimumInRotatedSortedArrayII() {}
	
	/*
	 * same solution but skip repeats on both end after finding mid.
	 * this increases the Time complexity to O(n)
	 * space constant
	 */
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = (r+l) >>1;
            while(l<r && l < mid && nums[l] == nums[mid]) l++;
            while(l<r && r > mid && nums[r] == nums[mid]) r--;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }
	
    public int findMinSolTwo(int[] nums) {
        if(nums.length == 0) return 0;
        int l = 0;
        int r = nums.length - 1;
        
        while(l<r){
            while(l<r && nums[l] == nums[r]) l++;
            if(l == r) return nums[l];
            
            int mid = (r+l)/2;
            
            if(nums[mid] > nums[r]){
                l = mid +1;
            }else{
                r= mid;
            }
        }
        
        return nums[l];
    }
}
