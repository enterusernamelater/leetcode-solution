package leetcode.conquer.sol.recursion;

/*
 * this is a recursive solution based on a dp approach 
 * the Time complexity is O(m*n) where m is height of the matrix and n is the width of the matrix
 * the space complexity is O(m*n)
 */
public class UniquePathsIIRecursiveSol {
	public UniquePathsIIRecursiveSol() {}

	private int[][] table;
	private int[][] obstacleGrid;
	private int w;
	private int h;
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0) return 0;

		this.w = obstacleGrid[0].length;
		this.h = obstacleGrid.length;

		this.table = new int[h][w];
		this.obstacleGrid = obstacleGrid;

		return helper(h-1,w-1);
	}

	private int helper(int h, int w){
		if(w<0 || h < 0) return 0;
		
		if(obstacleGrid[h][w] == 1) return 0;
		
		if(w==0 && h==0) return 1;
		
		if(table[h][w] > 0) return table[h][w];
		
		table[h][w] = helper(h-1,w) + helper(h,w-1);
		return table[h][w];
	}
}
