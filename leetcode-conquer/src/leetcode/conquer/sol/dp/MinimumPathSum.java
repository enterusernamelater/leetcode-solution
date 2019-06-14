package leetcode.conquer.sol.dp;

/*
 * a self wrote dp solution the idea is I calcualte each grid's min sum and then at the end 
 * I pick from the min betweeb the (index above or the index to the left) to calculate to min sum
 * Time o(h*w) space o(h*w) as the space complexity of the grid
 */
public class MinimumPathSum {
	public MinimumPathSum() {}
	
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int h = grid.length;
        int w = grid[0].length;
        
        for(int i=0;i<h;i++)
            for(int j=0;j<w;j++){
                if(i==0 && j==0){
                    continue;
                }else if(i==0){
                    grid[i][j] += grid[0][j-1];
                }else if(j==0){
                    grid[i][j] += grid[i-1][0]; 
                }else{
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }  
            }
        
        return grid[h-1][w-1];
    }
}
