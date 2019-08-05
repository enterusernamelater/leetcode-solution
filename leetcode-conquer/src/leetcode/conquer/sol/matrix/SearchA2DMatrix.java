package leetcode.conquer.sol.matrix;

/*
 * search this item by using a step search alg
 * doing a row -- if we find the current val in matrix is greater than the target
 * otherwsie col ++
 * until we find the target
 * if no target found we return false;
 * 
 * Time O(h+w), Space constant. 
 */
public class SearchA2DMatrix {

	public SearchA2DMatrix() {}

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) return false;

		int i = matrix.length - 1;
		int j = 0;

		while(i >= 0 && j < matrix[0].length){
			if(matrix[i][j] == target) return true;

			if(matrix[i][j] > target){
				i--;
			}else{
				j++;
			}
		}

		return false;
	}
}
