



package leetcode.conquer.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import leetcode.conquer.sol.heap.TheSkylineProblem;

/*
 * a class where I test my shit :)
 */
public class Main {
	public static void main(String[] args) {
		TheSkylineProblem sol = new TheSkylineProblem();
		int[][] buildings = new int[][] {{0,2,3},{2,5,3}};
		sol.getSkyline(buildings);
		Iterator<int[]> i;
		int[][] v = new int[0][0];
		List<int[]> list = new ArrayList<>(Arrays.asList(v));
		int[] arr = new int[0];
		String[] strs = new String[] {"a","b","c","d"};
		List<String> list3 = Arrays.stream(strs).collect(Collectors.toList());
		Set<String> set = new HashSet<>(list3);
	}
}
