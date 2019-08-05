package leetcode.conquer.sol.binarysearch;

/*
 * This sol uses a binary search approach to search on a matrix
 * the key to do the search is by converting a arr index from the matrix
 * baxk to the row and col see comment below
 * detail explanation see leetcode sol
 * Time(Log(n*m)) Space constant
 */
public class SearchA2DMatrixBinarySearchSol {
	
	public SearchA2DMatrixBinarySearchSol() {}

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) return false;
		int m = matrix.length, n = matrix[0].length;

		int l = 0;
		int r = n*m - 1;

		while(l <= r){
			int mid = (l+r) >> 1;

		//the key to binary search a matrix is this:
		//row = idx/n and col = idx % n. 
		//the formula above converts matrix into a sorted arr
			int val = matrix[mid/n][mid%n];

			if(val == target) return true;

			if(val < target){
				l = mid + 1;
			}else{
				r = mid - 1;
			}	
		}

		return false;
	}
}
