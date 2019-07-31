package leetcode.conquer.sol.matrix;

/*
 * rotate diagonally and then rotate vertically 
 * detailed explanation here:
 * https://www.youtube.com/watch?v=qko3FDWDKcQ
 * Time O(h*w) Space constant
 */
public class RotateImage {
	public RotateImage() {}

	public void rotate(int[][] matrix) {
		if(matrix.length == 0) return;

		int h = matrix.length;
		int w = matrix[0].length;

		for(int i=0; i<h; i++){
			for(int j=i+1; j<w; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		for(int i=0; i<h; i++){
			for(int j=0; j<w/2; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][w-1-j];
				matrix[i][w-1-j] = tmp;
			}
		}
	}
}
