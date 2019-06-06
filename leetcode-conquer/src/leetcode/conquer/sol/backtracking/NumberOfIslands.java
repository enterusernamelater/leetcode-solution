package leetcode.conquer.sol.backtracking;

/*
 * This is a dfs question by visiting every index in the matrix 2d. 
 * and change 1 to 0  when all 1s are turn to 0 return to the original and the loop continues.
 * this time complexity is only o(w*l) since when only backtrack if we found 1 in the 2d matrix. 
 * we will not visit them again
 * space is constant o(1)
 */
public class NumberOfIslands {
	public NumberOfIslands() {}
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int w = grid[0].length;
        int h = grid.length;
        int ans = 0;
        
        for(int i=0;i<h;i++)
            for(int j=0; j<w;j++){
                ans+=grid[i][j]-'0';
                helper(grid,i,j,w,h);
            }
        
        return ans;
    }
    
    private void helper(char[][] grid, int i, int j, int w, int h){
        if(i==h || i<0 || j==w || j<0 || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        helper(grid, i+1,j,w,h);
        helper(grid, i-1,j,w,h);
        helper(grid, i,j+1,w,h);
        helper(grid, i,j-1,w,h);
    }
}
