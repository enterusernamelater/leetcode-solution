package leetcode.conquer.sol.dp;

/*
 * this is a dp solution, where dp[i][j] stores the starting position of the s that has a substring ending at i(inclusive) that matches the subsequence in
 * t that ends in j (inclusive)
 * after finding all starting index, we do a final loop at the last col of t in dp, top to bottom and find the min length of the substring s and return
 * the result. if nothing found we return empty string
 * Time O(m*n)
 * Space O(m*n)
 */
public class MinimumWindowSubsequence {
	public MinimumWindowSubsequence() {}
	
	public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];//this dp stores all the starting index of s matches t
        for(int i=0;i<=m;i++){
            dp[i][0] = i+1;
        }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int val1 = dp[i-1][j]; //starting index one index before i that matches pattern t[j];
                //if the current char on s matches current chat on t, we take the value of i-1 and j-1 on 
                //dp see if one index before i and before j matches, if so thats our starting index.
                int val2 = s.charAt(i-1) == t.charAt(j-1)? dp[i-1][j-1] : 0;
                
                //when both val1 and val2 are not null we pick the later index in our s as the new starting index
                //as the later index will alwasy result a shorter distance in length 
                if(val1 != 0 && val2 != 0){
                    dp[i][j] = Math.max(val1,val2);
                }else if(val1 != 0){
                    dp[i][j] = val1;
                }else{
                    dp[i][j] = val2;
                }
            }
        }
        
        //in the end we loop through the last col on pattern t and find the min length of the substring s that has subsequence in t.
        int start = 0;
        int end = Integer.MAX_VALUE;
        for(int i=0; i<=m;i++){
            if(dp[i][n] !=0 && (i - (dp[i][n]-1) < end - start)){
                start = dp[i][n] - 1;
                end = i;
            }
        }
        return end == Integer.MAX_VALUE? "" : s.substring(start,end);
    }
}
