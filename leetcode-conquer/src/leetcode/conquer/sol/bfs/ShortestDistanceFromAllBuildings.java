package leetcode.conquer.sol.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * matrix bfs. using h arr and v arr to expand on each cell.
 * we cannot use dfs for this solution because only bfs can maintain the minimal distance and building count
 * Time O(k*mn) k is the number of buildings
 * Space constant
 */
public class ShortestDistanceFromAllBuildings {
	public ShortestDistanceFromAllBuildings() {}

	private int[] h = {1,-1,0,0};
	private int[] v = {0,0,1,-1};
	public int shortestDistance(int[][] grid) {
		if(grid == null || grid.length == 0) return -1;
		int m = grid.length;
		int n = grid[0].length;
		int[][] dis = new int[m][n];
		int[][] count = new int[m][n];
		int total = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j] == 1){
					total++;
					bfs(grid,dis,count,i,j,m,n,0);
				}
			}
		}

		Integer res = null;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(count[i][j] == total){
					res = res == null? dis[i][j] : Math.min(res, dis[i][j]);
				}
			}
		}

		return res == null? -1 : res;
	}

	private void bfs(int[][] grid, int[][] dis, int[][] count, int i, int j, int m, int n, int dist){
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];

		q.offer(new int[]{i,j});
		visited[i][j] = true;

		while(!q.isEmpty()){
			dist++;
			int size = q.size();
			for(int k=0; k<size; k++){
				int[] pos = q.poll();      
				for(int z=0; z<4; z++){
					int row = pos[0] + h[z];
					int col = pos[1] + v[z];
					if(row<0||row>=m||col<0||col>=n||grid[row][col] != 0||visited[row][col]) continue;

					q.offer(new int[]{row,col});
					dis[row][col]+=dist;
					count[row][col]++;

					visited[row][col]=true;
				}
			}
		}    
	}
}
