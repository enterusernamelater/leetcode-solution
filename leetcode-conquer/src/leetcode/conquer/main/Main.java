



package leetcode.conquer.main;

import leetcode.conquer.sol.heap.TheSkylineProblem;

/*
 * a class where I test my shit :)
 */
public class Main {
	public static void main(String[] args) {
		TheSkylineProblem sol = new TheSkylineProblem();
		int[][] buildings = new int[][] {{0,2,3},{2,5,3}};
		sol.getSkyline(buildings);
	}
}
