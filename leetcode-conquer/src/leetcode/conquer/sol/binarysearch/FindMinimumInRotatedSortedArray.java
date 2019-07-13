package leetcode.conquer.sol.binarysearch;

/*
 * this questions follows the same basics from question 34.
 * we change mid by comparing to the r if is greater than r we know smallest val
 * exists after mid so l = mid +1 if not then we know the smallest val exists before
 * mid so r = mid;
 * 
 * Time O(log(n) space O(1)
 */
public class FindMinimumInRotatedSortedArray {
	public FindMinimumInRotatedSortedArray() {}
	
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        
        int l = 0;
        int r = nums.length -1;
        
        while(l<r){
            int mid = (r+l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        
        return nums[l];
    }
}
