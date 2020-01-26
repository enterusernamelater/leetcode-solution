package leetcode.conquer.sol.recursion;

/*
 * this solution is the recursion verison of the dp solution
 * Time o(m*n)
 * Space O(m*n)
 */
public class MinimumPathSumRecursionSol {
	
	public MinimumPathSumRecursionSol() {}
	
    public int minPathSum(int[][] grid) {
        return helper(grid.length-1,grid[0].length-1,grid,new int[grid.length][grid[0].length]);
    }
    
    private int helper(int i, int j, int[][] grid, int[][] table){
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        
        if(i==0 && j ==0){
            table[i][j] = grid[i][j];
            return table[i][j];
        }
        
        if(table[i][j] > 0){
            return table[i][j];
        }
        
        table[i][j] = grid[i][j] + Math.min(helper(i-1,j,grid,table), helper(i,j-1,grid,table));
        return table[i][j];
    }
}
