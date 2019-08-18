package leetcode.conquer.sol.bit.manipulation;

/*
 * the solution is the same as find the unique char using bit operation
 * ideal case index will equal to num[index]
 * now we just need find the missing one in the indexs and nums[index]
 * Time O(n) Space O(1)
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        //in a perfect arr nums[index] = index find the left over using xor
        //now just like find missing char in string we use xor to find the missing int between index arr and nums
        
        int xor = 0; int i= 0;
        for(i=0;i<nums.length;i++){
            xor = xor ^ i ^ nums[i];
        }
        
        return xor^i;
    }
}
