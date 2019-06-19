package leetcode.conquer.sol.dp;

/*
 * the idea of this dp solution is to find all the sub replacement count for word1 and word2 length from 1..i-1 and 1..j-1 inclusive
 * and return the final result from the dp[w1.length][w2.length]
 * a detailed explanation video can be find in here:
 * https://www.youtube.com/watch?v=Q4i_rqON2-E
 * Time O(w1*w2) space O(w1*w2)
 */
public class EditDistance {
	public EditDistance() {}
	
	 public int minDistance(String word1, String word2) {
	        int w1 = word1 == null? 0 : word1.length();
	        int w2 = word2 == null? 0 : word2.length();
	        
	        int[][] dp = new int[w1+1][w2+1];
	        
	        for(int i=0;i<=w1;i++){
	            dp[i][0] = i;
	        }
	        
	        for(int i=0;i<=w2;i++){
	            dp[0][i] = i;
	        }
	        
	        for(int i=1;i<=w1;i++){
	            for(int j=1;j<=w2;j++){
	                int c = word1.charAt(i-1)==(word2.charAt(j-1))? 0 : 1;
	                
	                dp[i][j] = Math.min(dp[i-1][j-1]+c,Math.min(dp[i-1][j],dp[i][j-1])+1);
	            }
	        }
	        return dp[w1][w2];
	    }
}
