package leetcode.conquer.sol.bit.manipulation;

/*
 * see the comment, the question is to find the leftmost common digits between n and m
 * so we shift both number to the right if they are not the same.
 * while shift we keep a count 
 * if finally we found the same left most parts between n and m
 * while breaks and we shift n to the left by the count to form a proper res based on the given n and m bits.
 * Time (n) space constant
 */
public class BitwiseAndOfNumbersRange {
	public BitwiseAndOfNumbersRange() {}
	
    //The approach is to find the leftmost common digits of m and n, E.g. m=1110111, n=1110101 and answer is 1110100
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m<<count;
    }
}
