package leetcode.conquer.sol.bit.manipulation;

/*
 * take the original number's lsb append the res's lsb
 * this will result a reverse bit result
 * Time O(n)
 * Space constant
 */
public class ReverseBits {
	public ReverseBits() {}
	
    public int reverseBits(int n) {
        int res = 0;
        int i =0;
        while(i<32){
            int bit = (n >> i++ & 1);
            res |= bit;
            if(i < 32) res <<= 1; // when I is at 32 res is already 32 bits. so we dont shift to right right
        }
        
        return res;
    }
}
