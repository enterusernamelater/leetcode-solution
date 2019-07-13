package leetcode.conquer.sol.binarysearch;

/*
 * a binary search log(n) sol. the idea is we compare the mid val to the l val
 * if mid val is bigger than l and target is with in the range of l and mid then we move
 * right to mid. if target is outside of this range then we move l to mid + 1.
 * if mid is smaller than l then means we are in a rotated arr. we first check if target is in the range 
 * of mid and r if so we move l to mid +1 otherwise we move r to mid as target is in another interval
 * while doing all this the first thing i do is checking if mid is the target
 * at the end left will equal to r and the loop will break. the final check is to see if l is equal to target.
 * the key to this sol is we need to verify intervals first
 * Time O(log(n)) Space o(1)
 */
public class SearchInRotatedSortedArray {
	public SearchInRotatedSortedArray() {}
	
    public int search(int[] nums, int target) {   
        int l = 0;
        int r = nums.length-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(target == nums[mid]) return mid;
            if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target < nums[mid]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
        }
        
        return -1;
    }
}
