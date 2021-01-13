package leetcode.conquer.sol.dp;

import java.math.BigInteger;

/*
 * a stupid dp question with many corner cases
 * a explanation vid for this question can be find through the linke below:
 * https://www.youtube.com/watch?v=65j9zS-YWZo
 * however need to referring to some of the discussions solution as well.
 * Time o(N), space O(n)
 */
public class DecodeWaysII {
	public  DecodeWaysII() {}

	private static final int mod =1000000007;
	public int numDecodings(String s) {
		if(s == null || s.length()==0) return 0;
		long[] dp = new long[s.length()+1];

		dp[0]=1;
		dp[1]=s.charAt(0) == '0'? 0 : s.charAt(0) == '*'? 9 : 1;

		for(int i=2; i<=s.length();i++){
			char dig2 = s.charAt(i-1);
			char dig1 = s.charAt(i-2);

			if(dig2 == '*'){
				dp[i]+=dp[i-1]*9;
			}else if(dig2 > '0'){ 
				dp[i]+=dp[i-1];
			}

			if(dig1 == '*' && dig2 == '*'){
				dp[i] += dp[i-2]*15;
			}else if(dig1 == '*'){
				if(dig2 == '0'){
					dp[i] = dp[i-2]*2;   
				}else if(dig2 <= '6'){
					dp[i]+= dp[i-2]*2;
				}else{
					dp[i]+= dp[i-2];
				}
			}else if(dig2 == '*'){
				if(dig1 == '1'){
					dp[i]+=dp[i-2]*9;
				}else if(dig1 == '2'){
					dp[i]+=dp[i-2]*6;
				}
			}else if(dig1 > '0' && dig2 >= '0'){
				int val =Integer.valueOf("" + dig1 + dig2);
				if(val > 9 && val < 27){
					dp[i] += dp[i-2];
				}
			}
			dp[i] %= mod;
		}
		return (int)dp[s.length()];
	}
	
    public int concatenatedBinary(int n) {
        BigInteger mod = new BigInteger("1000000007");
        StringBuilder sb = new StringBuilder();
        for(int i=n;i>0;i--){
            String bits = Integer.toBinaryString(i);
            sb.insert(0, bits);
        }
        System.out.println(sb.toString().length());
        BigInteger res = new BigInteger(sb.toString(), 2);
        return res.mod(mod).intValue();
    }
}
