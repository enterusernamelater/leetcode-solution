package leetcode.conquer.sol.array;

/*
 * we record the profile along the way when our profile on the current stock remains positive
 * when profile droves to negative meaning current stock price today is cheaper the the day we bought
 * we dump the stock wo bought and buy the stock today as from now the stock today is the cheapest
 * which will maximize future profit
 * Time O(n)
 * Space constant
 */
public class BestTimeToBuyAndSellStock {
	public BestTimeToBuyAndSellStock() {}

	public int maxProfit(int[] prices) {
		int res = 0;
		int mula = Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++){
			if(prices[i]<mula){
				mula = prices[i];
			}

			res = Math.max(prices[i]-mula,res);
		}

		return res;
	}
}
