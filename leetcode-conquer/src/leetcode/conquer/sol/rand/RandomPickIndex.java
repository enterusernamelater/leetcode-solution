package leetcode.conquer.sol.rand;

import java.util.Random;


/*
 * simple Reservoir Sampling solution
 * when there is only 1 target, res is guaranteed to be the index as rand.nextIn(1) returns 0 and i will be picked
 * but as the count increases, the chance of i getting picked becomes less. 1/2,1/3,1/4 as there is only 1/n chances nextInt will
 * return a 0. this is called reservoir sampling
 * 
 * Time O(n) Space O(N)
 */
public class RandomPickIndex {
    Random rand = new Random();
    int[] nums;
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != target) continue;
            
            if(rand.nextInt(++count) == 0) res = i;
        }
        return res;
    }
}
