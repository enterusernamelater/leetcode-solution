package leetcode.conquer.sol.math;

/*
 * its a bit manipulation solution
 * check if this number has a extra bit..
 * Time constant
 * space constant
 * 
 * this question can also be done with in one liner: return n>0 && (n & (n-1)) == 0;
 * its a same bit manipulation approach that only 2^n & 2^n-1 can equal to 0. try this out but
 * after you understand below solution first
 */
public class PowerOfTwo {
	public PowerOfTwo() {}
	
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        int count = 0;
        while(n>0){
            int val = n & 1;
            if(val == 1) count++;
            if(count == 2) return false;
            n >>=1;
        }
        
        return true;
    }
}
