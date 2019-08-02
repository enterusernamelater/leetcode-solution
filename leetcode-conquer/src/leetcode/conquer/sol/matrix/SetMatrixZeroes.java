package leetcode.conquer.sol.matrix;

/*
 * A pretty straight forward solution follow this link beflow for detailed explanation:
 * https://www.youtube.com/watch?v=-I8w2_sN93c
 * Time O(h*w) Space in place
 */
public class SetMatrixZeroes {
	public SetMatrixZeroes() {}

	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return;

		boolean firstRow = false;
		boolean firstCol = false;

		int h = matrix.length;
		int w = matrix[0].length;

		for(int i = 0; i < w; i++) firstRow = firstRow || matrix[0][i] == 0;

		for(int i = 0; i < h; i++) firstCol = firstCol || matrix[i][0] == 0;

		for(int i = 1; i < h; i++){
			for(int j = 1; j < w; j++){
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for(int i = 1; i < w; i++)
			if(matrix[0][i] == 0)
				for(int j = 1; j < h; j++) 
					matrix[j][i] = 0;



		for(int i = 1; i < h; i++)
			if(matrix[i][0] == 0)
				for(int j = 1; j < w; j++)
					matrix[i][j] = 0;


		if(firstRow)
			for(int i=0; i<w; i++) matrix[0][i] = 0;

		if(firstCol)
			for(int i=0; i<h; i++) matrix[i][0] = 0;
	}
}
