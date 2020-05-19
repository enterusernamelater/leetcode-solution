package leetcode.conquer.sol.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * bfs approach starting from the boarder on each side of the oceans and count the ones connected
 * only trick here is the number compare is is reverse order.
 * time complexity close to O(n^2m + m^2n)
 * Space O(mn)
 */
public class PacificAtlanticWaterFlowBFS {
	public PacificAtlanticWaterFlowBFS() {}

	private int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return new ArrayList<>();

		int m = matrix.length;
		int n = matrix[0].length;

		boolean[][] table1 = new boolean[m][n];//points to p;
		boolean[][] table2 = new boolean[m][n];//points to a;

		Queue<int[]> q = new LinkedList<>();

		for(int j=0;j<n;j++){
			if(!table1[0][j])
				bfs(m,n,0,j,matrix,table1,q);
			if(!table2[m-1][j])
				bfs(m,n,m-1,j,matrix,table2,q);
		}

		for(int i=0;i<m;i++){
			if(!table1[i][0])
				bfs(m,n,i,0,matrix,table1,q);
			if(!table2[i][n-1])
				bfs(m,n,i,n-1,matrix,table2,q);
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

	private void bfs(int m, int n, int indexi, int indexj, int[][] matrix, boolean[][] table, Queue<int[]> q){
		q.offer(new int[]{indexi,indexj});
		table[indexi][indexj] = true;

		while(!q.isEmpty()){
			int size = q.size();

			for(int k=0;k<size;k++){
				int[] pval = q.poll();
				int min = matrix[pval[0]][pval[1]];
				for(int[] p : pos){
					int i = pval[0] + p[0], j=pval[1] + p[1];
					if(i < 0 || j < 0 || i==m || j==n || table[i][j] || matrix[i][j] < min) continue;
					table[i][j] = true;
					q.offer(new int[]{i,j});
				}
			}
		} 
	}
}
