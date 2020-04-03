package leetcode.conquer.sol.dp;

import java.util.HashMap;
import java.util.Map;

/*
 * a dp solution detailed explanation is below:
 * https://www.youtube.com/watch?v=KaXeidsmvVQ
 * time o(n^2), space o(n)
 */

public class PerfectSquares {
	public PerfectSquares() {}
	
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++) dp[i]=i;
        
        for(int i=1;i<=n;i++)
            for(int j=1; j*j<=i;j++)
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
        
        return dp[n];
    }
    
    
    /*
     * dfs + memorization, for loop limit to root(n) as root(n)^2 = n, so root(n) is the max and the smallest sqrt sum of a number
     * can be 1. while trying numbers between index to root(n) for sqrt sum. we keep current target number as n.
     * after the minimum results been calculated. we store the minimum result to the map of the number n.
     * 
     * unfortunately this solution is slow...
     */
    private Map<Integer,Integer> map = new HashMap<>();
    public int numSquaresDFS(int n) {
        helper(n,1);
        return map.get(n);
    }
    
    private int helper(int n, int index){
        if(map.containsKey(n)) return map.get(n);

        if(n == 0) return 0;
        //if is less than n meaning the i*i sqrt root number picked is too big so we return integer max -1 (avoid overflow for later +1)
        //so the res will remain the same
        if(n < 0) return Integer.MAX_VALUE-1;
        
        int res = Integer.MAX_VALUE;
        for(int i=index; i<=Math.sqrt(n); i++){
         
            int val = helper(n-i*i, i);
            res = Math.min(val+1,res);
        }
        
        map.put(n,res);
        return res;
    }
}
