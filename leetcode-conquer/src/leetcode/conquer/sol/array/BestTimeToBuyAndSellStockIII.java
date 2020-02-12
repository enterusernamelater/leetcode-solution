package leetcode.conquer.sol.array;

/*
 * simply put, you use the profit you obtained from your first buy/sell to decrease the second buy's coast, 
 * now is basically the same logic as the Best Time to Buy and Sell Stock I, 
 * after using the profit on the first buy/sell, apply the profit to buy the second stock, 
 * note that the second stock cost is decreased by the first but/sell's profit and can go to negative. 
 * (which is good because current stock value -- negative increase the profit on the second stock). 
 * In the end we find the max difference between the current stock sell to the second stock buy's cost value 
 * (including the profit deducted by the first buy/sell).
 * 
 * Note: the Max profit the always used to buy the second stock
 * and the min cost of second buy (after applying first buy/sell's profit) is always maintained. 
 * same as the BestTimeToBuyAndSellStockI the profit on the min cost of second buy is tracked at each current stock on sell2;
 * Time O(n)
 * Space Constant
 */
public class BestTimeToBuyAndSellStockIII {
	public BestTimeToBuyAndSellStockIII() {}

	public int maxProfit(int[] prices) {
		//note using a profit from the first buy/sell and buying the same sold stock and sell results the same profit as first buy/sell
		//because you only made profit from the frist buy/sell but the second buy/sell has no profit
		int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE, sell1 = 0, sell2 = 0;
		for(int price : prices){
			buy1 = Math.min(buy1,price);
			sell1 = Math.max(sell1, price - buy1); // this is going to be the first buy/sell profit
			buy2 = Math.min(buy2, price - sell1); //now we are buying the second stock but this time we deducted the cost with the profit from the first buy/sell
			sell2 = Math.max(sell2, price - buy2); // once the lowest cost for buy2 is found, now we just track the max difference between the current stock price and the bought second stock cost.
		}

		return sell2;
	}
}
