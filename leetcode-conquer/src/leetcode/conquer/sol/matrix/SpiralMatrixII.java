package leetcode.conquer.sol.matrix;

/*
 * very similar to its previous question no point explain see link below:
 * https://www.youtube.com/watch?v=dfGhf-Ko0L4
 * Time O(n^2) Space O(n^2)
 */
public class SpiralMatrixII {
	public SpiralMatrixII() {}

	public int[][] generateMatrix(int n) {
		int[][] m = new int[n][n];
		int left = 0;
		int right = n-1;
		int top = 0;
		int bottom = n-1;
		int k = 1;
		while(left<right && top<bottom){
			for(int i=left;i<right;i++){
				m[top][i] = k++;  
			}

			for(int i=top;i<bottom;i++){
				m[i][right] = k++;
			}

			for(int i=right;i>left;i--){
				m[bottom][i] = k++;
			}

			for(int i=bottom;i>top;i--){
				m[i][left] = k++;
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		if(n%2 != 0) m[n/2][n/2] = k;

		return m;
	}
	
	/*
	 * same approach to the first one just switch the arr.add with equals.
	 */
    public int[][] generateMatrixMySol(int n) {
        int[][] m = new int[n][n];
        
        int top = 0;
        int bottom = n-1;
        int left =0;
        int right = n-1;
        int c = 1;
        
        while(top <= bottom && left <= right){
            for(int i=left;i<=right;i++)
                m[top][i] = c++;
            
            for(int i=top+1;i<=bottom;i++)
                m[i][right] = c++;
            
            if(left == right || top == bottom) return m;
            
            for(int i=right-1;i>=left;i--)
                m[bottom][i] = c++;
            
            for(int i=bottom-1; i>top; i--)
                m[i][left] = c++;
            
            left++; right--; top++; bottom--;
        }
        return m;
    }
}
