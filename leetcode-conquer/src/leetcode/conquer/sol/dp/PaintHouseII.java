package leetcode.conquer.sol.dp;

/*
 * self wrote dp solution find min costs for each color on a house based on the previous house
 * time o(n*k^2) space (n*k)
 */
public class PaintHouseII {
	public PaintHouseII() {}
	
	/*
	 * this is a o(mn) solution or so called o(N*K)
	 * explanation as follows
	 */
    public int minCostII_O_MN(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs[0].length;
        int m = costs.length;
        
        //min 1 and min2 is used to maintain the MINIMUM COLOUR COSTS OF PAINTING "THE LAST HOUSE"
        //min1 is the smallest and min2 little bigger. eg min1 = 1, min2  = 3
        //index1 is used to maintain the index of min1 COLOUR COST OF "LAST HOUSE"
        //so that if you get a minimum cost at same index as previous (same colour) then you just add the min2 instead
        int min1 =0, min2 = 0, index = -1;
        
        for(int i=0;i<m;i++){
            //m1 and m2 used to maintain minimum costs of current house
            //idx1 is index of m1 of the current house
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx1 = -1; 
            for(int j=0;j<n;j++){
                int cost = costs[i][j] + (j == index? min2 : min1); //just check by index if not same colour
                
                //cost < m1 < m2
                if(cost < m1){
                    m2 = m1;
                    m1 = cost;
                    idx1=j;
                }else if(cost < m2){ // m1 < cost < m2
                    m2 = cost;
                }
            }
            
          //Update the global min1,min2 so that the current can become previous for next
            min1=m1; min2=m2;index=idx1;
        }
        
        return min1;
    }
    
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
