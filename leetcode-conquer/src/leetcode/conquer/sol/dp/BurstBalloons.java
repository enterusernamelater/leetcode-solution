package leetcode.conquer.sol.dp;

/*
 * this is a dp solution referring to the link below with very detailed explanation
 * https://www.youtube.com/watch?v=z3hu2Be92UA
 * the dp range starts with 1,1 2,2 (l=1) to 1,2, 2,3 (l=2) to 1,3 2,4 (l=3) to 1,4, 2,5 (l=4) l controls the dp i and j interval
 * the dp logic is the same as the divide and conquer solution
 * Time O(n^3)
 * Space o(N^2)
 */
public class BurstBalloons {
	
	public BurstBalloons() {}
	
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int n = nums.length;
        
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1] = 1;
        
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        
        int[][] dp = new int[n+2][n+2];
        
        for(int l=1; l<=n; l++){
            for(int i=1;i<=n+1-l;i++){ //n-l+1 to control the range so we dont overflow
                int j = i+l-1;
                for(int k =i;k<=j;k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + arr[i-1]*arr[k]*arr[j+1] + dp[k+1][j]);
                }
            }
        }
        
        return dp[1][n];    
    }
    
    private int[][] memo;
    //using divide and conqur by finding the max for the left and right on each index.
    public int maxCoinsDivideAndConqur(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int[] arr = new int[nums.length+2];
        
        for(int i=0;i<nums.length;i++) arr[i+1] = nums[i];
        arr[0] = arr[arr.length-1] = 1;
        this.memo = new int[arr.length][arr.length];
        
        return helper(arr,0,arr.length-1);
    }
    
    private int helper(int[] arr, int left, int right){
        if(left >= right) return 0;
        if(memo[left][right] != 0) return memo[left][right];
        
        int ans = 0;
        for(int i=left+1;i<right;i++){
            ans = Math.max(ans, arr[left] * arr[i] * arr[right] + helper(arr, left, i) + helper(arr,i,right));
        }
        memo[left][right] = ans;
        return ans;
    }
}
