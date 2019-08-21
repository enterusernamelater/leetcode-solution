package leetcode.conquer.sol.bit.manipulation;

/*
 * decrement n 1 at a time, every time we decrement by 1 we add increment sum.
 * using &(n-1) to elimiate the first bit
 * loop continues until n = 0;
 * note, when we have eg. 1000, &(n-1) will return 0111
 * Time O(n) Space constant
 */
public class NumberOf1Bits {
	public NumberOf1Bits() {}
	
    public int hammingWeight(int n) {
        int sum =0;
        
        while(n!=0){
            sum++;
            n &= (n-1);
        }
        return sum;
    }
    
    // you need to treat n as an unsigned value
    public int hammingWeightMySol(int n) {
        int sum = 0;
        System.out.println(n);
        while (n != 0){
        	//if and 1 gives one then the lsb is 1 we add sum
        	sum += n&1;
            //shifht to right, unsign shift
            n>>>=1;
        }
        return sum;
    }
}
