package leetcode.conquer.sol.recursion;

/*
 * this is a DFS + Memoization question. the solution idea
 * is compare the next one to the current val if the greater then continue.
 * if the next one is greater the current then the current is greater than the previous following the same fashion
 * then find the max size from the current four neighbor and store the size +1 to the current position. 
 * if the current pos is already visited then just return the result.
 * the Time o(m*n) where m is the height n is the width
 * the Space o(m*n);
 */
public class LongestIncreasingPathInAMatrix {
	private int[][] table;
	private int[][] matrix;
	private int h;
	private int w;

	public int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return 0;

		this.matrix = matrix;
		this.w = matrix[0].length;
		this.h = matrix.length;
		this.table = new int[h][w];

		int res =1;
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				res = Math.max(res,dfs(i,j));
			}
		}

		return res;
	}

	private int  dfs(int i, int j){
		if(table[i][j] > 0) return table[i][j];

		int max = 1;
		if(i+1 < h && matrix[i+1][j] > matrix[i][j]) max = Math.max(max,1+dfs(i+1,j));
		if(i-1 >= 0  && matrix[i-1][j] > matrix[i][j]) max = Math.max(max,1+dfs(i-1,j));
		if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]) max = Math.max(max,1+dfs(i,j-1));
		if(j+1 < w && matrix[i][j+1] > matrix[i][j]) max = Math.max(max,1+dfs(i,j+1));
		table[i][j] = max;

		return max;
	}
}
