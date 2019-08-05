package leetcode.conquer.sol.matrix;

/*
 * same solution as the step search sol from its previous question
 * Time(n+m) Space constant
 */
public class SearchA2DMatrixII {
	public SearchA2DMatrixII() {}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        
        while(i>=0 && j<n){
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
