package leetcode.conquer.sol.array;

/*
 * the first one is my solution, if the current sum plus the current index is less than the current index's val
 * we restart sum from the index
 * meanwhile we always keep track of the large sum at the bottom of the for loop
 */
public class MaximumSubarray {
	public MaximumSubarray() {}
	
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
    
        int sum = nums[0];
        int max = nums[0];
        
        for(int i = 1; i<nums.length; i++){
        	//when sum < 0, the current index has to be greater 
            if(sum < 0){
            	//when this if is hit current sum can be ignored as nums[i] is for sure bigger than the current sum
            	//so the current sum is definitely not the max sum, also mean sum here is a negative
            	//sum + nums[i] < nums[i] simpifies to sum < 0
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            
            max = Math.max(sum,max);
        }
        
        return max;
    }
    
    /*
     * c, its basically above logic written in a dp array style 
     * each index contents some sum, either index itself, if previous is negative OR sum to the previous index plus 
     * index's self value. 
     * during the calculation of the dp[i] sum we calcualte the max sum each time
     */
    public int maxSubArraySolTwo(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int res = dp[0];
        
        for(int i=1;i<nums.length;i++){
            dp[i] = dp[i-1]<0? nums[i] : dp[i-1] + nums[i];
            res = Math.max(dp[i],res);
        }
        
        return res;
    }
}
