package leetcode.conquer.sol.binarysearch;

/*
 * the difference of now having repeats in the arr is that
 * during find mid we will need to skip the repeats on l and h 
 * and this will bring the worse complexity to O(n)
 * everything else is the same the its previous question
 * Time O(n) Space o(1)
 */
public class SearchInRotatedSortedArrayII {
	public SearchInRotatedSortedArrayII() {}
	
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0;
        int r = nums.length-1;
        
        while(l<=r){
            while(l < r && nums[l] == nums[r]) l++;
            int mid = (l+r)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] >= nums[l]){
                if(nums[mid] > target && target >= nums[l]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
        }
        
        return false;
    }
}
