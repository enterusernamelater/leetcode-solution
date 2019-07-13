package leetcode.conquer.sol.binarysearch;

/*
 * the idea of this solution is using binary search first find start and then find end. and return the result
 * this question is interesting because this question will help you understand how to break out of the binary search loop
 * Time O(log(n)) Space O(1);
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
	FindFirstAndLastPositionOfElementInSortedArray(){}
	
	 public int[] searchRange(int[] nums, int target) {
	        int[] res = {-1,-1};
	        if(nums.length == 0) return res;
	        
	        //find first
	        int l = 0;
	        int r = nums.length -1;
	        //to break the loop in binary tree
	        //when only two left in the binary search each condition has to break loop otherwise infinite loop
	        //that means l has to increment or r has to decrement via mid.
	        while(l<r){
	            int mid = (l+r)/2;
	            if(target > nums[mid]){
	                l=mid+1;
	            }else{
	                r=mid;
	            }
	        }
	        if(nums[r] != target) return res;
	        int start = r;
	        
	        //findlast
	        l = start;
	        r = nums.length-1;
	        
	        while(l<r){
	            //here we do the + 1 to make sure when only two values left in the binary tree the mid always land on the right val
	            //so when l=mid, l increments and break the loop otherwise infinite loop
	            int mid = (l+r)/2 + 1;
	            if(target < nums[mid]){
	                r=mid-1;
	            }else{
	                l = mid;
	            }
	        }
	        
	        if(nums[l] != target) return res;
	        int end = l;
	        res[0] = start;
	        res[1] = end;
	        
	        return res;
	    }
}
