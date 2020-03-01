package leetcode.conquer.sol.array;

import java.util.Arrays;

/*
 * This solution is pretty much the same as the Best Time to Sell stock III logic.
 * except we need a special case handle which turning this problem into Best Time to Sell stock I
 * as in the stock question 3, we use the previous sell profit to buy current stock and return the last sell's profit
 * since the number of k is unknown we will need a container to keep track of the buy and profit on each transaction 
 * Time O(n*k)
 * Space O(n*k)
 */
public class BestTimeToBuyAndSellStockIV {
	public BestTimeToBuyAndSellStockIV () {}

	public int maxProfit(int k, int[] prices) {
		if(k == 0 || prices == null || prices.length == 0) return 0;

		//if k is greater than prices.length/2 meaning I can do transaction on every price, this becomes stock problem 1
		if(k > prices.length/2){
			int res = 0;
			for(int i=1;i<prices.length;i++)
				if(prices[i] > prices[i-1]) res+= prices[i] - prices[i-1];

			return res;
		}

		Container[] dp = new Container[k];
		Arrays.fill(dp, new Container(Integer.MAX_VALUE,0));
		for(int price : prices){
			int buy = Math.min(dp[0].buy, price);
			int sell = Math.max(dp[0].sell, price - buy);
			dp[0] = new Container(buy,sell);
			for(int i=1;i<dp.length;i++){
				buy = Math.min(dp[i].buy, price - sell);
				sell = Math.max(dp[i].sell, price - buy);
				dp[i] = new Container(buy,sell); 
			}
		}

		return dp[k-1].sell;
	}

	class Container{
		public int buy;
		public int sell;
		public Container(int buy, int sell){
			this.buy = buy;
			this.sell = sell;
		}
	}

}
