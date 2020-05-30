package leetcode.conquer.sol.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * bfs traverse with some corner cases to keep in mind
 * 1. when grid has no refresh orange return 0;
 * 2. when there is no rotten orange return 0 if no fresh ones. return -1 meaning not possible to covert 
 * 3. empty grids, no rotten and no fresh return 0
 * 4. check if there are still fresh ones left. if so return -1;
 * Time O(N) space constant
 */
public class RottingOranges {
	public RottingOranges() {}
	
	 int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	    public int orangesRotting(int[][] grid) {
	        if(grid == null || grid.length == 0) return 0;
	        
	        Queue<int[]> q = new LinkedList<>();
	        int m = grid.length;
	        int n = grid[0].length;
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(grid[i][j] == 2) q.offer(new int[]{i,j});  
	            }
	        }
	        int res = 0;
	        while(!q.isEmpty()){
	            int size = q.size();
	            res++;
	            for(int k=0;k<size;k++){
	                int[] pos = q.poll();
	                for(int s=0;s<4;s++){
	                    int i=pos[0],j=pos[1];
	                    i += dir[s][0];
	                    j += dir[s][1];
	                    if(i<0||i==m||j<0||j==n||grid[i][j] !=1) continue;
	                    grid[i][j] = 2;
	                    q.offer(new int[]{i,j}); 
	                }
	            }
	        }
	        
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(grid[i][j] == 1) return -1;
	            }
	        }
	        return res == 0? 0 : res-1;
	    }
}
