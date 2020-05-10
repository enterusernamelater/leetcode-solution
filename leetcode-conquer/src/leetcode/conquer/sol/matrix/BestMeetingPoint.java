package leetcode.conquer.sol.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * first we separate x and y points making this question one dimensional.
 * a sort is involved in capturing x and y points, when capture all points on one x/y point for example (1,3) (1,4) are on x axis
 * both will be captured before moving on to the next x axis which is 2. same logic goes to y
 * by analysis the equation you will realize that the min distance between p1 and p2 is basically there difference between x 
 * + their difference on their y points, based on this logic 
 * all we needed to do is finding the difference on the Xs and Ys and sum both results together
 * the calculation goes from two points further apart to closer. this is done by a while loop with l and r boundaries 
 * the stored x and y point values are in an increment order.
 * https://www.youtube.com/watch?v=vCRnwe0L0sg
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
    
    public int minTotalDistanceMyNavieSol(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        List<int[]> people = new ArrayList<>();
        List<int[]> meets = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    people.add(new int[]{j,i});
                }
                
                meets.add(new int[]{j,i});
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int[] meet : meets){
            int dis = 0;
            for(int[] p : people){
                dis+= Math.abs(p[0] - meet[0]) + Math.abs(p[1]-meet[1]);
            }
            res = Math.min(res,dis);
        }
        
        return res;
    }
}
