package leetcode.conquer.sol.recursion;

/*
 * This is a recursive solution link below explains better than I do
 * https://www.youtube.com/watch?v=UjiFFYU3EKM
 * Time O(n^2), Space O(n^2)
 */
public class CountDifferentPalindromicSubsequencesRecursionSol {
	public CountDifferentPalindromicSubsequencesRecursionSol() {}
	
	private static final int KMOD = 1000000007;
	private int[][] dp;	
	
    public int countPalindromicSubsequences(String s) {
        if(s == null || s.length() == 0) return 0;
        this.dp = new int[s.length()][s.length()];
        
        return helper(s,0,s.length()-1);
    }
    
    private int helper(String s, int start, int end) {
    	if(s == null || s.length() == 0) return 0;
    	if(start>end) return 0;
    	if(start == end) return 1;
    	if(dp[start][end] > 0) return dp[start][end];
    	
    	long ans = 0;
    	if(s.charAt(start) == s.charAt(end)) {
    		int l = start + 1;
    		int r = end - 1;
    		
    		while(l<=r && s.charAt(start)!= s.charAt(l)) l++;
    		while(l<=r && s.charAt(start)!= s.charAt(r)) r--;
    		
    		if(l>r) {
    			ans = 2*helper(s,start+1,end-1) +2;
    		}else if(l == r) {
    			ans = 2*helper(s,start+1,end-1) +1;
    		}else {
    			ans = 2*helper(s,start+1,end-1) - helper(s,l+1,r-1);
    		}
    	}else {
    		ans = helper(s,start,end-1) 
    			+ helper(s,start+1,end) 
    			- helper(s,start+1,end-1);
    	}
    	
    	return dp[start][end] = (int)((ans+KMOD) % KMOD);
    }
}
