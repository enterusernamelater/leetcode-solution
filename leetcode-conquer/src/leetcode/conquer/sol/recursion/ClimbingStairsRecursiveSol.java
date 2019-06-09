package leetcode.conquer.sol.recursion;

/*
 * a recursive sol based on the dp idea
 * Time O(n) space O(n)
 */
public class ClimbingStairsRecursiveSol {
	public ClimbingStairsRecursiveSol() {}
	
    private int[] arr;
    public int climbStairs(int n) {
        this.arr = new int[n+1];
        return helper(n);
    }
    
    private int helper(int n){
        if(n <= 1) return 1;
        if(arr[n]>0) return arr[n];
        arr[n] = helper(n-2) + helper(n-1);
        return arr[n];
    }
}
