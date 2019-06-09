package leetcode.conquer.sol.recursion;

/*
 * that question describtion confused me 
 * but the qeustion is simple 
 * dfs on all 1s and change them to 0 while counting the 1s each time
 * and find the max value 
 * Time O(w*h), Space: O(1) constant.
 */
public class MaxAreaOfIsland {
	private int res = Integer.MIN_VALUE;
    private int cur = 0;
    private int w;
    private int h;
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        this.w = grid[0].length;
        this.h = grid.length;
        
        for(int i=0;i<h;i++)
            for(int j=0; j<w;j++){
                dfs(grid,i,j);
                res = Math.max(res, cur);
                cur = 0;
            }
        
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j){
        if(i<0 || i==h || j<0 || j==w || grid[i][j] == 0) return;
        
        grid[i][j]=0;
        cur++;
        
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
