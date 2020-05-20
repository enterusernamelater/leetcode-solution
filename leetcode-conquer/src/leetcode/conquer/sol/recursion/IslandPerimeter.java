package leetcode.conquer.sol.recursion;

public class IslandPerimeter {
	public IslandPerimeter() {}

	public int islandPerimeter(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;

		int res = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j] != 1) continue;
				res = Math.max(res, dfs(i,j,m,n,grid));
			}
		}
		return res;
	}

	private int dfs(int i, int j, int m, int n, int[][] grid){
		if(i<0||i==m||j<0||j==n || grid[i][j] == 0) return 1;
		if(grid[i][j] == 3) return 0;

		grid[i][j] = 3;

		return dfs(i-1,j,m,n,grid)+dfs(i+1,j,m,n,grid)+dfs(i,j-1,m,n,grid)+dfs(i,j+1,m,n,grid);

	}
}
