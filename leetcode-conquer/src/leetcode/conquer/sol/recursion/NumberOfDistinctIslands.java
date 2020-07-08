package leetcode.conquer.sol.recursion;

import java.util.HashSet;
import java.util.Set;
/*
 * same as number of islands. just one trick to generate the key using a start point 0,0 and expand through dfs
 * if an island ended up having an existing key we know the island is a duplicate
 * 
 * Time O(n*m)
 * Space constant
 */
public class NumberOfDistinctIslands {
	public NumberOfDistinctIslands() {}
	
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(m,n,i,j,0,0,grid,sb);
                    if(set.add(sb.toString())) res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(int m, int n, int i, int j, int posi, int posj, int[][] grid, StringBuilder sb){
        if(i<0||i==m||j<0||j==n||grid[i][j] != 1) return;
        sb.append(Integer.valueOf(posi)).append(Integer.valueOf(posj));
        grid[i][j] = 0;
        
        for(int[] d : dir){
            dfs(m,n,i+d[0],j+d[1],posi+d[0],posj+d[1],grid,sb);
        }
    }
}
