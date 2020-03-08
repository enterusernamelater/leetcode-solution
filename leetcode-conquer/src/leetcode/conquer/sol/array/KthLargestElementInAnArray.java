package leetcode.conquer.sol.array;
/*
 * this is a quick select alg based on the quick sort alg. after the returning of the first pivot index nums.length-1
 * we check where pindex lands. if is greater than k, we do a quick sort on l to pindex-1. or if pindex is less than k
 * we do a quick sort on index pindex+1 to h. because k is always valid evetually pindex will land on k
 * since we dont have to traverse the whole array as we keep a low and high index based on the pindex compare to k
 * the average time complexity here is O(n)
 * space constant
 * node l and h starts 0 to nums.length-1, the interval change is similar to the branch search where pindex is the mid
 */
public class KthLargestElementInAnArray {
	public KthLargestElementInAnArray() {}
	
    public int findKthLargest(int[] nums, int k) {
        return helper(nums,k,0,nums.length-1);
    }
    
    private int helper(int[] nums, int k, int l, int h){
        int p = partition(nums,l,h);
        if(p == nums.length - k) return nums[p];
        else if(p > nums.length - k){
            return helper(nums,k,l,p-1);
        }else{
            return helper(nums,k,p+1,h);
        }
    }
    
    private int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int i = low;
        for(int j=low;j<=high;j++){
            if(nums[j]<=pivot){
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j] = tmp;
            }
        }
        
        return i-1;
    }
}
