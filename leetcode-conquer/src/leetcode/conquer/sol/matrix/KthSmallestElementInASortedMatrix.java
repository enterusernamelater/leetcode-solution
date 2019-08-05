package leetcode.conquer.sol.matrix;

/*
 * A binary search solution that first finds the mid value from low to high from the matrix as the 
 * matrix is sorted.
 * then use the mid find the kth smallest element that is closest to mid. and return the 'count' as the kth closest to mid
 * then use the count to pivot the l and r pointer. if count is lower than the target k then we know we need a higher mid
 * if the count is higher than the target k means we need a lower mid
 * to find the count of the kth smallest element that is cloest to mid. we traverse the matrix diagonally from bottom left to top right
 * if the current matrix val is smaller than the target mid. we increment j and increment
 * the count by the number of items in the same col up to i + 1 (+1 because inclusive).
 * if is greater we move up a row.
 * the traverse diagram looks like this:
 
*   *   *   * | *
*   *   * | *   *
*   *   * | *   *
*   * | *   *   *
* | *   *   *   *
*   *   *   *   *

 * Since is binary search Time Complexity close to O(nlog(n^2)), with constant space.
 */
public class KthSmallestElementInASortedMatrix {
	public KthSmallestElementInASortedMatrix() {};

	public int kthSmallest(int[][] matrix, int k) {
		if(matrix == null || matrix.length == 0) return 0;

		int l = matrix[0][0];

		int n = matrix.length;

		int r = matrix[n-1][n-1];

		while(l<r){
			int mid = (l+r) >> 1;
		int count = helper(mid,matrix);

		if(count < k){
			l=mid+1;
		}else{
			r=mid;
		}
		}

		return l;
	}

	private int helper(int mid, int[][] matrix){
		int n = matrix.length;
		int i = n - 1;
		int j = 0;
		int count = 0;
		while(i>=0 && j < n){
			if(matrix[i][j] > mid){
				i--;
			}else{
				j++;
				count+=i+1;
			}
		}
		return count;
	}
}
