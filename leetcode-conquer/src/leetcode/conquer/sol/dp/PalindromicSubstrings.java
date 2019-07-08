package leetcode.conquer.sol.dp;

/*
 * This question is a very similar question to the leetcode question number 5
 * the idea is building sub result on each substring combination from the string and determine if the 
 * any given substring combination is a palindromicSubstring. 
 * j - i represents a segment of substring. we check j-i is a PalindromicSubstring by first check if i char 
 * equas to j char if so then we check the previous substring j+1 to i-1 is PalindromicSubstring if so the the substring
 * whole is a PalindromicSubstring. there is a conor case where the length of the substring we are trying to determine if less than 3
 * in that case we only need to check if current i equals to current j because for a length 1 then if they equals to each other meaning they are 
 * PalindromicSubstring. for length 2 means we are checking the begining and ending char for the substring if they equals then they are PalindromicSubstring
 * if not they false.
 * a similar tutorial for this question can be found in this given link below:
 * https://www.youtube.com/watch?v=Fi5INvcmDos
 * 
 * 
 * Time O(n^2), Space O(n^2)
 */
public class PalindromicSubstrings {
	public PalindromicSubstrings() {}
	
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j>=0;j--){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i-j<2 || dp[i-1][j+1]);
                if(dp[i][j]) res++;
            }
        }
        return res;
    }
}
