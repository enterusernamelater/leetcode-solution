package leetcode.conquer.sol.array;

/*
 * basically finding the up hill interval in the array and add the difference between the top to bottom to the result
 * in the end we return the total res
 * one special case where arr is reached the end and the hill didnt go down we just add the difference between the end to the min
 * 
 * Time O(n)
 * Space constant
 */
public class BestTimeToBuyAndSellStockII {
	public BestTimeToBuyAndSellStockII() {}
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int res = 0;
		int mula = prices[0];

		for(int i=1;i<prices.length;i++){
			if(prices[i]<prices[i-1]){
				res+=prices[i-1] - mula;
				mula = prices[i];
			}else if(i==prices.length-1){
				res+= prices[i]-mula;
			}
		}

		return res;
	}
}
