package leetcode.conquer.sol.dp;

/*
 * dp solution, when the current char is the same as the pattern which is the t, we take the addition
 * of its previous match on the current pattern(dp[i-1][j]) + the previous index on s and previous index on t's match (dp[i-1[j-1])
 * if the current char is not the same we only care about s's previous match on the current pattern.
 * Time O(m*n)
 * Space O(m*n)
 */
public class DistinctSubsequences {
	
    public int numDistinct(String s, String t) {
        int[][] dp =new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++)
            dp[i][0] = 1;
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for(int i=1;i<=s.length();i++){
            for(int j=1; j<=t.length();j++){
                dp[i][j] = arr1[i-1] == arr2[j-1]? dp[i-1][j-1] + dp[i-1][j] : dp[i-1][j];
            }
        }
        
        return dp[s.length()][t.length()];
    }
}
