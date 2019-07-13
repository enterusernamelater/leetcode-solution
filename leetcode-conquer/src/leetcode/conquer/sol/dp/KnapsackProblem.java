package leetcode.conquer.sol.dp;
/*
 * this question is not a leetcode question but is a classic dp question
 * Time O(n*w) where w is the max weight; n is number of items.
 * Space O(n*w)
 */
public class KnapsackProblem {
	public KnapsackProblem() {}
	
	public int knapSack(int w, int[] wt, int[] val, int n) {
		if(n == 0 || w == 0) return 0;
		
		int[][] dp = new int[n+1][w+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=w;j++) {
				if(i==0 || j == 0) {
					dp[i][j] = 0;
				}else {
					if(wt[i-1] > j) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
					}
				}
			}
		}
		return dp[n][w];
	}
	
	public static void main(String args[]) 
	{ 
	    int val[] = new int[]{60, 100, 120}; 
	    int wt[] = new int[]{10, 20, 30}; 
	    int  W = 50; 
	    int n = val.length; 
	    KnapsackProblem sol = new KnapsackProblem();
	    System.out.println(sol.knapSack(W, wt, val, n)); 
	} 
}

