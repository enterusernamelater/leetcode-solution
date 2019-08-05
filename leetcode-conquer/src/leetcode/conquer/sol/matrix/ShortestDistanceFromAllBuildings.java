package leetcode.conquer.sol.matrix;

import java.util.LinkedList;
import java.util.Queue;

/*
 * the idea of this sol is that we need to keep track on each 0s howmany buildings can reacn
 * and what is the total distant for all building to meet at the spot.
 * when we encounter '1' in the grid we update the total building
 * we call bfs and update the surrounding 0s based on the '1'
 * the surrounding 0s mean up, down, left and right. achieved by using rowDir arr and colDir arr
 * each time bfs gets called we initialize a visited matrix so that same element to visit twice. 
 * once canReach and disMap both are updated. in the end we loop through both matrix
 * first find the canReach matrix where val equals to the totalBuilding. once the val found we update
 * the result with the corresponding disMap val. during the ending loop we keep the res by its minimal
 * a very detailed explanation video can be find in here:
 * https://www.youtube.com/watch?v=F7AM7AGJZYE
 * Time O((mn)^2) space O(m*n)
 */
public class ShortestDistanceFromAllBuildings {
	
	private int[] rowDir = {1, -1, 0, 0};
	private int[] colDir = {0, 0, 1, -1};
	private int[][] canReach;
	private int[][] disMap;
	private int[][] grid;
	private boolean[][] visited;
	private int n;
	private int m;
	
	public ShortestDistanceFromAllBuildings() {}

	public int shortestDistance(int[][] grid) {
		if(grid == null || grid.length == 0) return -1;    
		this.grid = grid;

		this.m = grid.length;
		this.n = grid[0].length;

		this.canReach = new int[m][n];
		this.disMap = new int[m][n];
		int totalBuilding = 0;

		for(int i=0; i<m; i++){
			for(int j=0;j<n;j++){
				if(grid[i][j] == 1){
					totalBuilding++;
					bfs(i,j);
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(canReach[i][j] == totalBuilding){
					res = Math.min(res,disMap[i][j]);
				}
			}
		}

		return res == Integer.MAX_VALUE? -1 : res;
	}

	private void bfs(int row, int col){
		Queue<int[]> q = new LinkedList<>();
		int distant = 0;
		this.visited = new boolean[m][n];
		q.offer(new int[]{row,col});
		visited[row][col] = true;

		while(!q.isEmpty()){
			distant++;
			int size = q.size();

			for(int i=0; i < size; i++){
				int[] pos = q.poll();
				for(int j=0; j<4;j++){
					int rowPos = pos[0] + rowDir[j];
					int colPos = pos[1] + colDir[j];

					if(!isValid(rowPos,colPos)) continue;
					visited[rowPos][colPos] = true;
					canReach[rowPos][colPos]++;
					disMap[rowPos][colPos]+=distant;

					q.offer(new int[]{rowPos,colPos});
				}
			}
		}
	}

	private boolean isValid(int row, int col){
		if(row<0 || row > m-1 || col < 0 || col > n-1) return false;
		if(visited[row][col]) return false;
		if(grid[row][col] != 0) return false;

		return true;
	}
}
