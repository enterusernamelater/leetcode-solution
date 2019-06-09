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
        if(obstacleGrid[0][0] == 1) return 0;
        
        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;
        
        int[][] table = new int[h+1][w+1];

        for(int i=0;i<h;i++)
            for(int j=0; j<w;j++){
                if(obstacleGrid[i][j] == 1){
                    table[i+1][j+1] = 0;
                }else{
                    table[i+1][j+1] = i+1 == 1 && j+1 == 1? 1 : table[i][j+1] + table[i+1][j];
                }
            }
        
        return table[h][w];
    }
}
