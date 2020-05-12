package leetcode.conquer.sol.matrix;

public class FacebookSampleQuestion1 {
	public FacebookSampleQuestion1() {}
	
	public static int[][] helper(int n){
		int[][] m = new int[n][n];
		
		int count=1;
		for(int i=0;i<n;i++) {
		
			//top
			for(int j=i;j<n-i;j++) m[i][j] = count++;
			//right
			for(int j=i+1;j<n-i;j++) m[j][n-i-1] = count++;
			//bottom
			for(int j=n-i-2;j>=i;j--) {
				m[n-i-1][j] = count++;
			}
			//left
			for(int j=n-i-2;j>i;j--) m[j][i] = count++;
		}
		
		return m;
	}
}
