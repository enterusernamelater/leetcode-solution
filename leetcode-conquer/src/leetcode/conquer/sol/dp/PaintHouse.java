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
	
	//keep track of each house's min cost up to this point so in the end we find the min total cost
	//by finding the min between the three colours on the last house.
	//my solution is faster than below
    public int minCostMySol(int[][] costs) {
        if(costs == null || costs.length ==0) return 0;
        int n = costs[0].length;
        int m = costs.length;
        
        int val1 = costs[0][0], val2 = costs[0][1], val3 = costs[0][2];
        for(int i=1;i<m;i++){
            int tmp1 = costs[i][0] + Math.min(val2,val3);
            int tmp2 = costs[i][1] + Math.min(val1,val3);
            int tmp3 = costs[i][2] + Math.min(val1,val2);
            val1 = tmp1; val2 = tmp2; val3 = tmp3;
        }
        return Math.min(val1, Math.min(val2,val3));
    }
	
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
