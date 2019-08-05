package leetcode.conquer.sol.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * a very smart sol we first transform the 2d matrix into 1d because distance in x and y are independent
 * after that we adding all x and y values into an array
 * from observation we know that the minimal distance between two points are there difference between x and y
 * so we loop through x and y arrays from both end and find the total differences 
 * the sum of the total difference on the x and y array is our result.
 * this link below explains this strategy very well 
 * https://www.youtube.com/watch?v=vCRnwe0L0sg
 * 
 * Time O(n*m) Space O(m+n)
 */
public class BestMeetingPoint {
	public BestMeetingPoint() {}
	
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
        
        int m = grid.length, n = grid[0].length;
        
        for(int i=0; i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j] == 1)
                    y.add(i);
        
        for(int i =0; i<n; i++)
            for(int j=0; j<m; j++)
                if(grid[j][i] == 1)
                    x.add(i);
        
        return getMin(x) + getMin(y);
    }
    
    private int getMin(List<Integer> list){
        int l = 0;
        int r = list.size() - 1;
        
        int res = 0;
        while(l<r){
            res+= list.get(r--) - list.get(l++); 
        }
        
        return res;
    }
}
