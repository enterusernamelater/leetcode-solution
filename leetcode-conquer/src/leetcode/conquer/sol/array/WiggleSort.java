package leetcode.conquer.sol.array;

/*
 * when index is odd the index needs to be greater than previous
 * when index is even the index needs to be smaller than previous
 * if condition above does not match we swap between the previous and current index.
 * Time O(n) in place sort 
 * Space constant
 */
public class WiggleSort {
	public WiggleSort() {}
	
    public void wiggleSort(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(i%2 == 0){
                if(nums[i] > nums[i-1]){
                    int tmp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = tmp;
                }
            }else{
                if(nums[i] < nums[i-1]){
                    int tmp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }
}
