package leetcode.conquer.sol.matrix;

/*
 * use dfs find the end and backtracking by increment the distance 1 at a time. while backtracking record each points' max
 * value into the map
 * Time complexity my gues is close to O((NM)^2)
 * space O(mn)
 */
public class LongestIncreasingPathInAMatrix {
	public LongestIncreasingPathInAMatrix() {}
	
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int n = matrix[0].length;
        int m = matrix.length;
        int[][] map = new int[m][n];
        
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res = Math.max(res,dfs(matrix,map,i,j,m,n));
            }
        }
        
        return res;
    }
    
    private int dfs(int[][] matrix, int[][] map, int i, int j, int m, int n){
        if(map[i][j] > 0) return map[i][j];
        
        int res = 1;
        if(i-1>=0 && matrix[i-1][j] > matrix[i][j]) res = Math.max(res, dfs(matrix,map,i-1,j,m,n)+1);
        if(i+1<m && matrix[i+1][j] > matrix[i][j]) res = Math.max(res, dfs(matrix,map,i+1,j,m,n)+1);
        if(j-1>=0 && matrix[i][j-1] > matrix[i][j]) res = Math.max(res, dfs(matrix,map,i,j-1,m,n)+1);
        if(j+1<n && matrix[i][j+1] > matrix[i][j]) res = Math.max(res, dfs(matrix,map,i,j+1,m,n)+1);
        map[i][j] = res;
        return res;
    }
}
