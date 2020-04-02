package leetcode.conquer.sol.binarysearch;

/*
 * Same concept as in H Index but since the array is now sorted we use binary search to find the result
 * Time O(log(n))
 * space constant
 */
public class HIndexII {
	
	public HIndexII() {}
	
    public int hIndexMySol(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int l =0;
        int r = nums.length -1;
        int n = nums.length;
        int res = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(nums[mid] >= n - mid){
                res = n-mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return res;
    }

    //concept in this solution is the same at previous but using a little binary search trick 
    //so when no result found l will be shifted to n. so in the end l-n = 0; this way we dont need a res to keep track
    //of our value
    public int hIndex(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int l =0;
        int r = nums.length -1;
        int n = nums.length;
        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(nums[mid] >= n - mid){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return n-l;
    }
}
