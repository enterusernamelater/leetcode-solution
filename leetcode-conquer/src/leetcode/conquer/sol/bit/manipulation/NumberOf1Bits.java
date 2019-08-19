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
}
