package leetcode.conquer.sol.dp;

import java.util.Arrays;

/*
 * dp solution first sort the paris so to guarantee we will always find the 
 * pairs[i][0] during looping so if paris[i][0] is greater than its previous thanks to the sort
 * we can add  paris[i][0] to its previous sol val +1, dp[j]+1) also there is a res val to keep track the max val
 * Time O(n^2) Space O(n)
 */
public class MaximumLengthOfPairChain {
	public MaximumLengthOfPairChain() {}
	
    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0) return 0;
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs,(a,b) -> (a[0]-b[0]));
        Arrays.fill(dp,1);
        int res = 0;
        for(int i=0;i<pairs.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
          res =  Math.max(res,dp[i]);
        }
        
        return res;
    }
}
