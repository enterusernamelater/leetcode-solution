package leetcode.conquer.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.conquer.sol.recursion.WordLadderII;

public class Main {
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
				
		List<String> str = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		
		WordLadderII sol = new WordLadderII();
		
		sol.findLadders(start, end, str);
	}
}
