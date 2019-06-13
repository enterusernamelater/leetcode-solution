package leetcode.conquer.sol.dp;

import java.util.Arrays;

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
	
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }
}
