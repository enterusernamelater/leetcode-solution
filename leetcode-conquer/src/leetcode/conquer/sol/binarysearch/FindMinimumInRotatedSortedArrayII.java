package leetcode.conquer.sol.binarysearch;

/*
 * basically a same solution as its previous. only difference is that we need to skip the repeats.
 * since we are skipping the repeats the time now is O(n) thinking about the worst case were all vals are the same
 * Space O(1)
 */
public class FindMinimumInRotatedSortedArrayII {
	public FindMinimumInRotatedSortedArrayII() {}
	
    public int findMin(int[] nums) {
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
