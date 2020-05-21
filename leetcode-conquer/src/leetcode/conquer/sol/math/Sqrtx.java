package leetcode.conquer.sol.math;

/*
 * see comment, just need to remember this, you are looking for a value 
 * that val*val = x. so this is a classic binary search solution
 * Time O(log(n))
 * Space O(N)
 */
public class Sqrtx {
	public Sqrtx() {}
	
    public int mySqrt(int x) {
        if(x<2) return x;
        int l=1;
        int r = x;
        
        while(l<r){
            int mid = l+(r-l)/2;
            if(mid == x/mid) return mid;
            //you are finding a range that the square root is between x..x+1;
            //mid*mid < x but mid+1 * mid+1 > x you found the right range
            if(mid < x/mid && (mid+1) > x/(mid+1)) return mid;
            
            if(mid < x/mid){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        
        return r;
    }
}
