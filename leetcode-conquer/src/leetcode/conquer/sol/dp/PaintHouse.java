package leetcode.conquer.sol.dp;

/*
 * This is a pure DP solution, we calculate the min color fee for every house (row) on each color(col)
 * and then we find the min in the last house(last row) when offset the color by picking different color from the
 * previous comparing to now.
 * Time O(n), Space O(1)
 * link for reference:
 * https://www.youtube.com/watch?v=fZIsEPhSBgM
 */
public class PaintHouse {
	public PaintHouse() {}
	
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}
