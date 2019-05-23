package leetcode.conquer.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.conquer.sol.backtracking.WordBreakII;

public class Main {
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> str = new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"));
		
		WordBreakII sol = new WordBreakII();
		List<String> res = sol.wordBreak(s, str);
		for(String val : res)
			System.out.println(val);
	}
}
