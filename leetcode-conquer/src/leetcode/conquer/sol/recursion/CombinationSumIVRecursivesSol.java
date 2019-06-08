package leetcode.conquer.sol.recursion;

import java.util.Arrays;

/*
 * same as the combination recursive but each time we recursive we keep track the target count so next time during 
 * recursive, when we encounter the target count we simply return the answer recorded. and this will not have duplication
 * because the starting points is different by the recursive arr.
 * Time(n*2^n) space o(target);
 */
public class CombinationSumIVRecursivesSol{
    int res = 0;
    
    public CombinationSumIVRecursivesSol() {}
    
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target ==0) return 0;
        int[] arr = new int[target+1];
        Arrays.fill(arr,-1);
        arr[0] = 1;
        return helper(nums,target,arr);
    }
    
    private int helper(int[] nums, int target,int[] arr){
        if(arr[target] != -1){
            return arr[target];
        }
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(target>=nums[i])
            count+=helper(nums,target-nums[i],arr);
        }
        return arr[target] = count;
    }
}
