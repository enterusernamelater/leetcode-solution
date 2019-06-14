package leetcode.conquer.sol.dp;

/*
 * self wrote dp solution find min costs for each color on a house based on the previous house
 * time o(n*k^2) space (n*k)
 */
public class PaintHouseII {
	public PaintHouseII() {}
	
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length ==0) return 0;
        
        int h = costs.length;
        for(int i=1;i<h;i++){
            for(int j=0;j<costs[i].length;j++){
                int min = Integer.MAX_VALUE;
                for(int k=0; k<costs[i-1].length;k++){
                    if(k!=j)
                        min = Math.min(min,costs[i-1][k]);
                }
                costs[i][j] += min;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i=0;i<costs[h-1].length;i++){
            res = Math.min(res,costs[h-1][i]);
        }
        
        return res;
    }
}
