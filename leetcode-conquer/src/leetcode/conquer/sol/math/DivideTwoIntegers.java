package leetcode.conquer.sol.math;

/*
 * this solution is by taking times 2 on the divisor each time and add the number of time 2 each time happened
 * into the result and minus dividend with the final times 2 that is less that dividend 
 * loop continues until a-b is not >=0;
 * this vid link below:
 * https://www.youtube.com/watch?v=htX69j1jf5U
 * Time O(n) space constant
 */
public class DivideTwoIntegers {
	public DivideTwoIntegers() {}

	public int divide(int dividend, int divisor) {
		if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
		if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

		int a = Math.abs(dividend);
		int b = Math.abs(divisor);
		int res = 0;
		
		
		//by doing a -b >= 0 by pass overflow
		while(a-b >= 0){
			int x =0;
			
			//same here doing a - (b<<x) >= 0 by pass overflow
			while(a - (b<<x) >=0){
				x++;
			}
			res += 1<<(x-1);
			a -= b<<(x-1);
		}

		return (dividend>=0) == (divisor >=0)? res : -res;
	}
	
    public int divideSolTwo(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        long divid = (long)dividend;
        long div = (long)divisor;
        
        if(divid < 0) divid = -divid;
        if(div < 0) div = -div;
        
        int res =0;
        
        while(divid >= div){
            int shift = 0;
            while(divid >= (div << shift) ){
                shift++;
            }
            
            res += 1<<(shift - 1);
            divid -= div<<(shift - 1);
        }
        
        return dividend >= 0 == divisor >= 0? res : -res; 
    }
}
