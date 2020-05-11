package leetcode.conquer.sol.dp;

/*
 * Dp solution, each day when buy we take either the profit obtain from the day before and buy today's price
 * or we just hold from yesterday's buy
 * sell is the profit, you either carry over the profit from yesterday's sell or you sell today
 * in the end the last day's profilt obtained is the result.
 * Time O(n)
 * Space O(n) the space here can be constant tho, because I only need four data variables.
 */
public class BestTimeToBuyAndSellStockwithCooldown {
	public BestTimeToBuyAndSellStockwithCooldown() {}
	
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        Data[] dp = new Data[prices.length+1];
        dp[0] = new Data(0,0);
        dp[1] = new Data(prices[0],0);
        
        for(int i=2;i<dp.length;i++){
            int buy = Math.min(prices[i-1] - dp[i-2].sell, dp[i-1].buy); //buy now with the profit taken two days ago or you hold.
            int sell = Math.max(dp[i-1].sell, prices[i-1] - dp[i-1].buy);
            //profit taken from yesterdays sell or sell today
            dp[i] = new Data(buy,sell);
        }
        
        return dp[prices.length].sell;
    }
    
    class Data{
        public int buy = 0;
        public int sell = 0; // profit
        
        public Data(int buy, int sell){
            this.buy = buy;
            this.sell = sell;
        }
    }
}
