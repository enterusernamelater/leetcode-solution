package leetcode.conquer.sol.dp;

import java.util.Arrays;

/*
 * a self wrote solution that does a 2 dimension dp
 * idea is similar to the CountDifferentPalindromicSubsequences sol
 * Time O(n^2) Space O(n^2)
 */
public class ArithmeticSlicesMySol {
	public ArithmeticSlicesMySol() {}
	
    public int numberOfArithmeticSlices(int[] arr) {
        if(arr.length < 3) return 0;
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        int res = 0;
        
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(i-j < 2){
                    dp[i][j] = arr[i] - arr[j];
                }else if((arr[i] - arr[i-1]) == dp[i-1][j]){
                    dp[i][j] = arr[i] - arr[i-1];
                    res++;
                }else{
                    continue;
                }
            }
        }
        
        return res;
    }
}
