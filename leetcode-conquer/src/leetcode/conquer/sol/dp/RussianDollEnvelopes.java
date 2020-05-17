package leetcode.conquer.sol.dp;

import java.util.Arrays;

/*
 * this is basically longest increasing subsequence problem
 * we sort the envelopes by weights and if weights are the same we sort the height 
 * in descending order to break out the the case for same weight so the increasing subsequence will reset
 * Time O(nLog(n)) Space O(n)
 */
public class RussianDollEnvelopes {
	public RussianDollEnvelopes() {}
	
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        
        //if weights are the same then we sort by the height in descending order
        Arrays.sort(envelopes, (a,b) -> a[0]==b[0]? b[1] - a[1] : a[0] - b[0]); 
        
        int len = 0;
        int[] dp = new int[envelopes.length];
        
        for(int[] val : envelopes){
            int index = Arrays.binarySearch(dp,0,len,val[1]);
            if(index < 0) index = -(index + 1);
            
            dp[index] = val[1];
            if(index == len) len++;
        } 
        return len;
    }
    
    
    public int maxEnvelopesDP(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a,b) -> (a[0] == b[0]? b[1]-a[1] : a[0] - b[0]));
        
        int[] dp = new int[envelopes.length];
        
        for(int i=0;i<envelopes.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int res = 0;
        for(int val : dp) res = Math.max(res,val);
        return res;
    }
}
