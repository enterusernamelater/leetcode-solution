package leetcode.conquer.sol.dp;

/*
 * this is a dp + dfs soluton
 * we need always think of the worst case scenario by find the most money you will pay
 * each time we split the array from lower and upper on the key we choose. 
 * and the min amount on the number we pick will be the gurrante win 
 * the time is permutation o(n!) 
 * space is o(n^2) as we need to use to track the calculated start to end index max amount.
 * check the leetcode solution for more detail
 */
public class GuessNumberHigherOrLowerII {
	
	public GuessNumberHigherOrLowerII() {}
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        return dp(table, 1,n);
    }
    
    private int dp(int[][] table, int s, int e){
        if(s>=e) return 0;
        if(table[s][e] != 0) return table[s][e];
        
        int res = Integer.MAX_VALUE;
        
        for(int i=s; i<=e;i++){
            int curr = i + Math.max(dp(table,s,i-1), dp(table,i+1,e));
            res = Math.min(res,curr);
        }
        table[s][e]=res;
        return res;
    }
}
