package leetcode.conquer.sol.dp;

/*
 * dp + bit manipulation 
 * referrs to the leet code solution for this question or the link below:
 * https://www.youtube.com/watch?v=QjEyO1137cM
 * Time O(n) Space O(n)
 */
public class CountingBits {
	public CountingBits() {}
	
	 public int[] countBits(int num) {
	        int[] dp = new int[num+1];
	        dp[0]=0;
	    
	        int bitVal = 1;
	        while(bitVal <= num){
	            int i = 0;
	            //when i is 1 less than bitval we need to renew bitval by *2 (a shift)
	            //so i will be resetted to 0 and bitval becomes the next bit to power of 2.
	            //we break when i+bitVal<=num avoid array index out of bound.
	            while(i<bitVal && i+bitVal<=num){
	                //at first bitVal is a number to a power of 2 eg. x^2
	                //so only one '1' in the dp[i+bitVal] i =0 and bitval = x^2;
	                //later on the + 1 here represents the x^2's 1
	                dp[i+bitVal] = dp[i]+1;
	                i++;
	            }
	            bitVal <<= 1;
	        }
	        return dp;
	    }
}
