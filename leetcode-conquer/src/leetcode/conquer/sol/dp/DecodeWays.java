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

	/*
	 * I first thought about using recursion to solve this problem but turns out the sample size is way too big. so ended up using dp 
	 * the solution is pretty simple. we start at the second char. if the second char is valid we take dp[i-1] as the total combination for taking only
	 * the second char. if the first and second chars both valid we take dp[i-2] as the total combination for taking both the first and second chars
	 * in order for the second char to be valid the second char cannot be 0
	 * in order for the first and second char to be valid the first char cant be 0 and both chars val cannot exceed 26
	 * Time O(N)
	 * Space O(N)
	 * 
	 * also attached the recursion solution although it will time out
	 */
    public int numDecodingsMySol(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=s.length();i++){
			char first = s.charAt(i-2);
			char second = s.charAt(i-1);
			String strVal = first - '0' > 0? new String(new char[]{first,second}) : "0";
			Integer val = Integer.valueOf(strVal);
			
			int firstVal = second - '0' > 0? dp[i-1] : 0;
			int secondVal = val > 0 && val <=26? dp[i-2] : 0;
			dp[i] = firstVal + secondVal;
		}
		
		return dp[s.length()];
    }
    
	private int res = 0;
	//NOTE: this solution will timeout but just as a reference
    public int numDecodingsRecursive(String s) {
        if(s == null || s.length() == 0) return 0;
		helper(s,0);
		return res;
    }
    
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
	
	private void helper(String s, int index){
		if(index >= s.length()){
			res++;
			return;
		}
		
		if(s.charAt(index) == '0') return;
		
		int i = index+1;
		int val = Integer.valueOf(s.substring(index,i));
		if(val > 0 && val <= 26){
				helper(s,i);
		}
		
		i = index+2;
		if(i<=s.length()){
			val = Integer.valueOf(s.substring(index,i));
			if(val > 0 && val <= 26){
					helper(s,i);
			}
		}
	}
}
