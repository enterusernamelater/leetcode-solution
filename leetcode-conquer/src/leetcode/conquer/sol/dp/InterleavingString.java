package leetcode.conquer.sol.dp;

/*
 * This is dp solution with the idea that we look for the sub sols on every 1...i-1 on w1 and 1..j-1 on w2 
 * to find the substring of s2. when we reach to the end we check on dp[w1][w2] from the condition as following transition function
 * Time O(s3*s1) space O(s1*s2)
 */
public class InterleavingString {
	public InterleavingString() {}
	
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        int w1 = s1.length();
        int w2 = s2.length();
        
        boolean[][] dp = new boolean[w1+1][w2+1];
        dp[0][0] = true;
        for(int i=1;i<=s3.length();i++){
            for(int l1=0; l1<=i && l1<=w1;l1++){
                int l2 = i-l1;
                if(l2>w2) continue;
                dp[l1][l2] = (l1>0 && dp[l1-1][l2] && s3.charAt(i-1) == s1.charAt(l1-1))
                           || (l2>0 && dp[l1][l2-1] && s3.charAt(i-1) == s2.charAt(l2-1));
            }
        }
        
        return dp[w1][w2];
    }
}
