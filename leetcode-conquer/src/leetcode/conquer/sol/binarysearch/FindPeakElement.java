package leetcode.conquer.sol.binarysearch;

/*
 * after finding mid, check if mid is on a increasing slope. if so we make the mid a new beginning l = mid +1
 * exclude mid because we already know mid+1 is greater than mid on this increasing slope, when its on a increasing slope
 * we know there will be a peak in front
 * when mid is greater than mid +1 we know mid is on a decreasing slope therefore we make a new end on r=mid. we cannot
 * exclude mid as mid can be a peak
 * when mid is at a decreasing slope we know there is a peak behind mid, or the peak can be mid itself
 * Time O(log(n)) space O(1)
 */
public class FindPeakElement {
	public FindPeakElement() {}
	
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return 0;
        int l =0;
        int r = nums.length-1;
        
        while(l<r){
            int mid = (l+r)/2;
            
            if(nums[mid]>nums[mid+1]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        
        return l;
    }
}
