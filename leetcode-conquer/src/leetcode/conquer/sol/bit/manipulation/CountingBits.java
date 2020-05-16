package leetcode.conquer.sol.bit.manipulation;

/*
 * i represents each binary bit on 2^x 0, 1, 2, 4, 8 and so on
 * once a binary bit is found we complete the current binary bit to the next binary bits value
 * using the already calculated difference stored in the res.
 * Time O(n)
 * Space O(n)
 */
public class CountingBits {
	public CountingBits() {}
	
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        //when j is 1 less than i we need to renew i by *2 (a shift)
        //so i will be resetted to 0 and i becomes the next bit to power of 2.
        //we break when j+i<=num avoid array index out of bound.
        //at first i is a number to a power of 2 eg. x^2
        //so only one '1' in the dp[i+bitVal] i =0 and i = x^2;
        //later on the + 1 here represents the x^2's 1
        for(int i=1;i<=num;i<<=1){
            for(int j=0;j<=i && j+i<=num;j++){
                res[i+j] = res[j]+1;   
            }
        }
        
        return res;
    }
}
