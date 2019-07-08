package leetcode.conquer.sol.dp;

/*
 * pretty much a self wrote soltuion that follows the pattern from the question 
 * PalindromicSubstrings
 * logic is if the j-i length is 1 then the length in dp is 1
 * if is 2 then if they are the same then length is 2 otherwise of of them is Palindrome
 * when j to i length is greater than 2, then if i and j is the same then we grab the previous substring 
 * j+1 to i-1's max Palindrome length and plus 2. if they are not the same then we need to consider the max
 * val from the substring j+1 to i and j to i-1;
 * the tutorial below has a very similar approach but using a i to j substring instead of going backwards from
 * j to i by decrementing j from i.
 * https://www.youtube.com/watch?v=OZX1nqaQ_9M
 *  Time O(n^2) Space O(n^2)
 */
public class LongestPalindromicSubsequence {

	public LongestPalindromicSubsequence() {}

	public int longestPalindromeSubseq(String s) {
		if(s == null || s.length() == 0) return 0;
		int[][] dp = new int[s.length()][s.length()];

		for(int i=0;i<s.length();i++){
			for(int j=i;j>=0;j--){
				if(i-j < 1){
					if(i-j > 0 && s.charAt(i) == s.charAt(j)){
						dp[i][j] = 2;
					}else{
						dp[i][j] = 1;
					}
				}else{
					if(s.charAt(i) == s.charAt(j)){
						dp[i][j] = dp[i-1][j+1] + 2;
					}else{
						dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
					}
				}
			}
		}

		return dp[s.length()-1][0];
	} 
}
