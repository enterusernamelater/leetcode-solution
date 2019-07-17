package leetcode.conquer.sol.dp;

/*
 * a two dimension dp solution that keeps track of the 
 * sub problem same val count, if they are the same i increment based on the i-1 j-i val 
 * while incrementing I have a res var to keep track the total max res;
 * Time O(m*n) Space (m*n)
 */
public class MaximumLengthOfRepeatedSubarray {
	public MaximumLengthOfRepeatedSubarray() {}
	
    public int findLength(int[] a, int[] b) {
        if(a.length ==0 || b.length == 0) return 0;
        int[][] dp = new int[a.length+1][b.length+1];
        int res = 0;
        
        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=b.length;j++){
                if(a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
