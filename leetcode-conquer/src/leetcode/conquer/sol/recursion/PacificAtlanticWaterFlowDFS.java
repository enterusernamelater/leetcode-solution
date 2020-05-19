package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlowDFS {
	public PacificAtlanticWaterFlowDFS() {}
	
    private int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] table1 = new boolean[m][n];//points to p;
        boolean[][] table2 = new boolean[m][n];//points to a;
        
        for(int j=0;j<n;j++){
            dfs(m,n,0,j,matrix,table1,Integer.MIN_VALUE);
            dfs(m,n,m-1,j,matrix,table2,Integer.MIN_VALUE);
        }
        
        for(int i=0;i<m;i++){
            dfs(m,n,i,0,matrix,table1,Integer.MIN_VALUE);
            dfs(m,n,i,n-1,matrix,table2,Integer.MIN_VALUE);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(table1[i][j] && table2[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int m, int n, int i, int j, int[][] matrix, boolean[][] table, int min){
        if(i < 0 || j < 0 || i==m || j==n || table[i][j] || matrix[i][j] < min) return;
        table[i][j] = true;
        for(int[] val : pos){
            dfs(m,n,i+val[0],j+val[1],matrix,table,matrix[i][j]);
        }
    }
}
