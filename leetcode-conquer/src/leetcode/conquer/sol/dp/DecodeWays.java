package leetcode.conquer.sol.dp;

/*
 * a very nice dp problem
 * Time O(n), Space O(n)
 * the idea is based on the link below:
 * https://www.youtube.com/watch?v=cQX3yHS0cLo
 * we build the sub results adding ways to decode for the previous one letter and the previous two latters
 * if the one letter is greater than 0
 * then we are adding the way to decode from its previous dp[i-1]
 * as for example 226 we pick 6
 * the way to decode for 6 is based on the previous result of 22
 * we have 22,6 and 2,2,6 
 * if the two letters from previous is within 1 to 26
 * then we decode the previous example as 2,26 which is only one way
 * the total ways of decoding the above examples are 3 ways
 */
public class DecodeWays {
	public DecodeWays() {}

	public int numDecodings(String s) {
		int[] dp = new int[s.length()+1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0'? 0 : 1;

		for(int i=2;i<=s.length();i++){
			int dig1 = Integer.valueOf(s.substring(i-1,i));
			int dig2 = Integer.valueOf(s.substring(i-2,i));

			if(dig1>0){
				dp[i]+=dp[i-1];
			}

			if(dig2>9 && dig2<27){
				dp[i]+=dp[i-2];
			}
		}

		return dp[s.length()];
	}
}
