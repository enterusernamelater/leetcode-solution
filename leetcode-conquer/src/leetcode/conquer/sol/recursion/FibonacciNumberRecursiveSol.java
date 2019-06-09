package leetcode.conquer.sol.recursion;

/*
 * a recursive sol based on the dp solution
 * Time O(n) Space O(n)
 */
public class FibonacciNumberRecursiveSol {
	public FibonacciNumberRecursiveSol() {}
	
    private int[] arr;
    public int fib(int n) {
        this.arr = new int[n+1];
        return helper(n);
    }
    
    public int helper(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(arr[n]>0) return arr[n];
        arr[n] = helper(n-1) + helper(n-2);
        return arr[n];
    }
}
