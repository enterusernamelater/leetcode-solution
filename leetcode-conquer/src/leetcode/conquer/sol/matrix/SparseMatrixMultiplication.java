package leetcode.conquer.sol.matrix;

/*
 * A math question that convert a SparseMatrixMultiplication into code 
 * Time O(ha*wa*wb) space O(ha*wb)
 */
public class SparseMatrixMultiplication {
	public SparseMatrixMultiplication() {}
	
    public int[][] multiply(int[][] a, int[][] b) {
        int ha = a.length; int wa = a[0].length;
        int wb = b[0].length;
        
        int[][] res = new int[ha][wb];
        for(int i=0;i<ha;i++){
            for(int j=0;j<wa;j++){
                for(int k=0;k<wb;k++){
                    if(a[i][j] == 0) continue;
                    res[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        
        return res;
    }
}
