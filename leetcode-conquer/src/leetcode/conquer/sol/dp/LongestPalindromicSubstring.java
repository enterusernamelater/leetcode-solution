package leetcode.conquer.sol.dp;

/*
 * This question is a classic dp question the solution is very similar to the 
 * longest palindromic subsequence question
 * Time O(n*n) space O(n^2)
 */
public class LongestPalindromicSubstring {
	public LongestPalindromicSubstring() {}
	
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        
        for(int i=0;i<s.length();i++){
            for(int j=i; j>=0; j--){               
               dp[i][j] = s.charAt(i) == s.charAt(j) && (i-j<2 || dp[i-1][j+1]);
               if(dp[i][j] && (i-j+1) > res.length()) res = s.substring(j,i+1);
            }
        }
        
        return res;
    }
}
