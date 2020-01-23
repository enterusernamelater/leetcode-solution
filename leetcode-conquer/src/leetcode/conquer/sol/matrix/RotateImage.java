package leetcode.conquer.sol.matrix;

/*
 * rotate vertically then rotate diagonally 
 * detailed explanation here:
 * https://www.youtube.com/watch?v=qko3FDWDKcQ
 * Time O(h*w) Space constant
 */
public class RotateImage {
	public RotateImage() {}

	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return;
		int n = matrix[0].length;
		int m = matrix.length;

		int l = 0;
		int r = m - 1;

		//swap top and bottom
		while(l<r){
			for(int j=0;j<n;j++){
				swapTopBottom(l,r,j,matrix);
			}
			l++;
			r--;
		}

		//swap diagonally
		for(int i=0; i<n; i++){
			for(int j=i;j<n;j++){
				swapDiag(j,j,i,matrix);
			}
		}
	}

	private void swapDiag(int l, int r, int i, int[][] matrix){
		int tmp = matrix[i][l];
		matrix[i][l] = matrix[r][i];
		matrix[r][i] = tmp;
	}

	private void swapTopBottom(int l, int r, int i, int[][] matrix){
		int tmp = matrix[l][i];
		matrix[l][i] = matrix[r][i];
		matrix[r][i] = tmp;
	}
}
