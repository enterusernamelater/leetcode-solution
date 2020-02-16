package leetcode.conquer.sol.matrix;

/*
 * look for negative once found just calculate the rest since is sorted
 * Time O(m*n)
 * Space constant
 */
public class CountNegativeNumbersInASortedMatrix {
	public CountNegativeNumbersInASortedMatrix() {}

	public int countNegatives(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int res =0;
		int n= grid[0].length;
		int m = grid.length;

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j] < 0){
					res+= n-j;
					break;
				}
			}
		}

		return res;
	}
}
