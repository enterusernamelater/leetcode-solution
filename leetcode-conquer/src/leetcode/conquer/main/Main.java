package leetcode.conquer.main;

import leetcode.conquer.sol.matrix.FacebookSampleQuestion3;

/*
 * a class where I test my shit :)
 */
public class Main {
	public static void main(String[] args) {
		int[][] res = Main.helper(8);
		System.out.println(1);
		
		FacebookSampleQuestion3 sol = new FacebookSampleQuestion3();
		//Solution s = new Solution();
		String str = "a b c d";
		String[] ar = str.split(" ", 2);
		
		for(String s : ar) {
			System.out.println(s);
		}
		
		char[] chs1 = "abc".toCharArray();
		
		
		System.out.println(chs1[0]^chs1[1]^chs1[2]);
	}
	
	
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
