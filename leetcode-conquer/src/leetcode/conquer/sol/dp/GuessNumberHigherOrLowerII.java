package leetcode.conquer.sol.dp;

/*
 * dp[i][j] is the minimal cost to guess from range(i...j).
 * When you choose an x where i <= x <= j, 
 * you may find the target number from left i...x-1, 
 * or you may find the target number from the x+1...j, 
 * because you don't know which way should go, so to guarantee 
 * you have enough money to find the target, 
 * you need to prepare the more, which is max(dp[i][x-1], dp[x+1][j]).
 * 
 * the question is asking how much money you need to have AT LEAST to win the game;
 * therefore we are finding a minimal cost out of the above max cost
 * O(n!) time space;
 * space O(N)
 */
public class GuessNumberHigherOrLowerII {
	
	public GuessNumberHigherOrLowerII() {}

    public int getMoneyAmount(int n) {
        if(n == 0) return 0;
        int[][] dp = new int[n+1][n+1];
        
        dfs(dp,1,n);
        return dp[1][n];
    }
    
    private int dfs(int[][] dp, int l, int r){
        if(l>=r) return 0; //when l == r meaning you have guessed the right number 0 cost
        if(dp[l][r] >0) return dp[l][r];
        
        int res = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
        	//you need to prepare the max spending to cover the pick 
            int val = i + Math.max(dfs(dp,l,i-1), dfs(dp,i+1,r));
            //keep track of the min cost will eventually give you how much AT LEAST you need to win the game
            res = Math.min(res,val);
        }
        
        dp[l][r] = res;
        return res;
    }
}
