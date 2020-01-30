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

	/*
	 * first draw the dp matrix in a note book 
	 * for every index we travel, 
	 * we move up i-1 meaning we take the previous match to word 2 and remove our last char therefore we have a +1 meaning we remove the last one char dp[i-1][j] + 1
	 * we move left meaning we find the edit max to match word2's a letter short, the we add the current j in word 2 
	 * therefore we have a +1 meaning we inserted the letter on j index in word2 dp[i][j-1] + 1
	 * both cases above remove the i letter on word 1 or add the j letter on word 2 regardless j and i chars are the same
	 * then lastly we find the max edit a letter short on word 1 and word 2: i-1 and j-1, if i and j matches then no need to + 1, otherwise we need to +1 
	 * to replace the current letter on word1 i to match the current letter on word2 j
	 * we take the min above as our result in our current dp
	 * 
	 *   special cases handle:
	 *   when i or j are 0;
	 *   dp[i][j-1]+1 meaning take the previous edit max that matches the current j word2 and remove the current letter i 
	 *   j-i+val meaning we take remove all previous letters before j and see if i and j are the same if the same we dont add one. otherwise we add 1
	 *   meaning we are replacing the current i to j in word2
	 *   we then do the same take the min between the two conditions above. as our final result.
	 * 
	 * Time o(m*n) Space o(m*n)
	 * 
	 */
	public int minDistanceMySol(String word1, String word2) {
		if(word1 == null || word1.length() == 0) return word2.length();
		if(word2 == null || word2.length() == 0) return word1.length();

		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n;j++){
				int val = word1.charAt(i) == word2.charAt(j)? 0 : 1;
				if(i == 0){
					dp[i][j] = j>0? Math.min(dp[i][j-1]+1,j-i+val) : val;
				}else if(j == 0){
					dp[i][j] = i>0? Math.min(dp[i-1][j]+1,i-j+val) : val;
				}else{
					dp[i][j] = Math.min(dp[i-1][j-1] + val, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
				}
			}
		}

		return dp[m-1][n-1];
	}
	
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
