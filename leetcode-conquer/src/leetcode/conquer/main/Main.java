package leetcode.conquer.main;

import leetcode.conquer.sol.array.TheSkylineProblem;

public class Main {
	public static void main(String[] args) {
		TheSkylineProblem sol = new TheSkylineProblem();
		
		sol.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});
	}
}
