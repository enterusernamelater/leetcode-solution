package leetcode.conquer.sol.binarysearch;

/*
 * This is a leetcode sol, we fist save the mid to the r if mid > mid +1
 * then let l incrementing until we reach the ans. 
 * during l increments if another mid is found where mid > mid +1 we move r =mid to 
 * save the new mid and keep letting l increment.
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
