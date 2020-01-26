package leetcode.conquer.sol.dp;

/*
 * this is a pure dp solution, the solution is very samliar to the first UniquePath sol
 * but when we encounter the obstacle 1 when need to set the path at the table to 0
 * Time O(m*n) m is the height of the table and n is the length of the table
 * Space O(m*n)
 */
public class UniquePathsII {
	
	public UniquePathsII() {}
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        
        dp[1][1] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i-1][j-1] == 1){
                    dp[i][j] = 0;
                }else if(i==1 && j==1){
                    continue;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[m][n];
    }
}
