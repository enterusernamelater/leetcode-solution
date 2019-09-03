package leetcode.conquer.sol.design;

/*
 * basically the same solution as the previous question RangeSumQueryMutable
 * only difference is that we are building a 2d tree but same logic we find all next vals
 * on each row and col and when getting sum we trace all the way to the top to the parent
 * **** see RangeSumQueryMutable's explanation ****
 * only thing to note is that we getting the range sum of an area we need to minus the areas outside the range
 * and adds back any areas that are overlapped. 
 * the build 2d tree cost Time O(n*m log(m*n)) get sum is O(log(nm)) update is O(log(nm))
 * Space O(n)
 */
public class RangeSumQuery2DMutable {
	private int[][] tree;
	private int[][] matrix;
	private int m;
	private int n;
	
	public RangeSumQuery2DMutable(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return;
		this.matrix = matrix;
		this.m = matrix.length;
		this.n = matrix[0].length;
		this.tree = new int[m+1][n+1];
		createTree(matrix);
	}

	private void createTree(int[][] matrix){
		for(int i=1;i<tree.length;i++){
			for(int j=1;j<tree[0].length;j++){
				int val = matrix[i-1][j-1];
				updateTree(i,j,val);
			}
		}
	}

	private void updateTree(int row, int col, int val){
		for(int i=row; i<tree.length; i+=(i & -i)){
			for(int j=col; j<tree[0].length; j+=(j & -j)){
				tree[i][j] += val;
			}
		}
	}

	public void update(int row, int col, int val) {
		updateTree(row+1,col+1, val - matrix[row][col]);
		matrix[row][col] = val;
	}

	private int getSum(int row, int col){
		int res = 0;
		for(int i=row; i>0; i-=(i & -i)){
			for(int j=col; j>0; j -=(j & -j)){
				res+=tree[i][j];
			}
		}

		return res;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		//+ getSum(row1,col1) is adding the overlap back to the result.
		return getSum(row2+1, col2+1) - getSum(row1,col2+1) - getSum(row2+1,col1) + getSum(row1,col1);
	}
}
