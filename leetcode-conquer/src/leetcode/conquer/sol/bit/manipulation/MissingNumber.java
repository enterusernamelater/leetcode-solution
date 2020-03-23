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
    
    /*
     * 首项加末项乘以讲述除以二 得到本该有的总和 在于nums的总和相减就得到的了答案
     * Time O(n)
     * Space constant
     */
    public int missingNumberMathSol(int[] nums) {
        int sum = 0;
        int max = nums.length;
        for(int val : nums) sum+=val;

        return (max*(max+1))/2 - sum;
    }
}
