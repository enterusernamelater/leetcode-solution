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

	//two binary search pass O(Log(n*m)), same result comparing to the one above
	//solution above is more elegant but mine is more particle.
	public boolean searchMatrixSolTwo(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

		//two binary search solution
		int l = 0;
		int r = matrix.length - 1;
		int mid = 0;
		while(l<=r){
			mid = l+(r-l)/2;
			if(matrix[mid][0] == target || matrix[mid][matrix[mid].length-1] == target) return true;
			else if(matrix[mid][0] < target && matrix[mid][matrix[mid].length-1] > target) break;
			else if(matrix[mid][0] < target){
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}

		l=0;
		r=matrix[mid].length-1;
		int index = mid;
		while(l<=r){
			mid = l+(r-l)/2;
			if(matrix[index][mid] == target) return true;
			else if(matrix[index][mid]<target){
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}

		return false;
	}
}
