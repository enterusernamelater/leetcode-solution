package leetcode.conquer.sol.array;

import java.util.Arrays;

/*
 * first we sort the array so we know the number of paper citations are in increasing order
 * now we start from last index, the greatest citation paper by reversing the array for loop, you can also
 * sort reversely but this will save memory. until we reach a paper number that is greater than the current paper citation
 * we have found the max h index; 
 * O(nlogn)
 * space constant
 */
public class HIndex {
	public HIndex() {}
	
    public int hIndex(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        //h index 是paper的个数 和至少paper citation的数
        
        for(int i=1;i<=n && nums[n-i] >= i; i++){
                res = i;
        }
        
        return res;
    }
}
