package leetcode.conquer.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.conquer.sol.dp.LongestPalindromicSubsequence;

public class Main {
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
				
		List<String> str = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		int[] arr = new int[5];
		Arrays.fill(arr, 1);
		
		LongestPalindromicSubsequence sol = new LongestPalindromicSubsequence();
		
		sol.longestPalindromeSubseq("bbbab");
	}
}
