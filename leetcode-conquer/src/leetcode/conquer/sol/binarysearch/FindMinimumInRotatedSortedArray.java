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
	/*
	 * we mid is greater than the r we now its not possible the res in the the l to mid range
	 * but when l is greater than mid we know its possible the res is in the l to mid range eg, 51234
	 * deal the first case is the simple binary tree
	 * second case we cannot just cut the arr but we can increment the l and see if the next l is still greater than mid
	 * once a valid range found we return the first index l
	 * Time O(Log(n))
	 * Space constant
	 */
    public int findMinMySol(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid+1;
            }else if(nums[mid] < nums[l]){
                l++; 
            }else{
               return nums[l];
            }
        }
        //handle a special case when nums.length == 1
        return nums[l];
    }
    
    //above solution can be simplified so that when l is greater than mid 
    //we just shrink r=mid as we know the valid answer is in the range.
    //the shrink r=mid continues, eventually if a false case exists where l greater than mid
    //the mid will land on the greater l, in that case the l will be incremented by l=mid+1 in the while loop
    //until there is no more nums[mid] > r cases, where r is the previous mid;
    //therefore it is important to keep shrink r=mid inclusive 
    //Time Log(n);
    //Space constant
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
