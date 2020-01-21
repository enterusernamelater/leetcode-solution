package leetcode.conquer.sol.dp;

/*
 * a dp solution that is very similar to leetcode Regular Expression Matching 10. the dp basically means
 * if chars between the string and the pattern are the same or pattern is ? looking at the previous index i-1,j-1
 * if pattern is * then any one of the following is true will make the create i j dp true, see below:
 * 	[i-1,j-1], [i-1,j], [i,j-1]
 *    t t
 *    t x
 *    
 *  Time O(m*n) Space O(m*n)
 */
public class WildcardMatching {
	public WildcardMatching() {}
	
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for(int i=1;i<=n;i++)
            if(p.charAt(i-1) == '*') 
                dp[0][i] = dp[0][i-1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        
        return dp[m][n];
    }
}
