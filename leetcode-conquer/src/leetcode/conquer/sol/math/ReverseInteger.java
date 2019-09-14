package leetcode.conquer.sol.math;

/*
 * reverse a integer
 * self wrote
 */
public class ReverseInteger {
	public ReverseInteger() {}
	
    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            res = res*10 + x%10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0; 
            x/=10;
        }
        return (int)res;
    }
    
    public int reverseSolTwo(int x) {
        int res = 0;
        while(x != 0){
            int tmp = res*10 + x%10;
            if(tmp/10 != res) return 0;
            res = tmp;
            x/=10;
        }
        return res;
    }
}
