package leetcode.conquer.main;

import java.util.HashMap;
import java.util.Map;

import leetcode.conquer.sol.matrix.FacebookSampleQuestion3;

/*
 * a class where I test my shit :)
 */
public class Main {
	public static void main(String[] args) {
		
		char[] chs1 = "whakli".toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(char c : chs1) map.put(c, 1);
		
		for(char c : map.keySet()) System.out.println(c);
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
