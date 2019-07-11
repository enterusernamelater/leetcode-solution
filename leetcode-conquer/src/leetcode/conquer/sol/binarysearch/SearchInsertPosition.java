package leetcode.conquer.sol.binarysearch;

/*
 * Binary search sol find the right insertion spot
 * a conor case handle when the left index lands on the val that is smaller than the target 
 * then we increment by 1
 * Time O(n) Space O(n)
 */
public class SearchInsertPosition {
	
	public SearchInsertPosition() {}
	
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        
        int l = 0;
        int r = nums.length -1;
        
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]<target){
                l = mid + 1;
            }else if(nums[mid]>target){
                r = mid;
            }else{
                return mid;
            }  
        }
        
        if(nums[l] < target) return l+1;
        
        return l;
    }
}
