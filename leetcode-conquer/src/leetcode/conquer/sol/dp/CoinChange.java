package leetcode.conquer.sol.dp;

import java.util.Arrays;
import java.util.HashMap;

/*
 * this is a pure dp solution where we calculate the dp arr for every amount index
 * on each coin and for each index val when take the min
 * until the end we will reach the final index which is the amount 
 * if the index return Integer.MAX_VALUE when return -1;
 * detailed solution explained in this link below:
 * https://www.youtube.com/watch?v=uUETHdijzkA
 * Time O(n*amount)
 * Space O(amount)
 */
public class CoinChange {
	public CoinChange() {}
	
	//basically the same as the dfs memorization soltuion below. but I sorted so that once 
	//a coin value is greater than the amount I know the rest is no point checking
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length && i-coins[j]>=0;j++){
                 if(dp[i-coins[j]] < 0) continue;
                dp[i] = dp[i] < 0? dp[i - coins[j]] + 1 : Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        
        return dp[amount];
    }
    
    //dfs solution with memorization
    private HashMap<Integer,Integer> map = new HashMap<>();
    public int coinChangeDFS(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0) return 0;
        
        helper(coins,amount);
        return map.get(amount);
    }
    
    private int helper(int[] coins, int amount){
        if(amount < 0) return -1;
        if(map.containsKey(amount)) return map.get(amount);
        if(amount == 0) return 0;
        
        int res = -1;
        for(int i=0;i<coins.length;i++){
            int val = helper(coins,amount-coins[i]) + 1;
            if(val == 0) continue;
            res = res<0? val : Math.min(res,val);
        }
        
        map.put(amount,res);
        return res;
    }
}
