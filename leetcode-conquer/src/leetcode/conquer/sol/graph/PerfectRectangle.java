package leetcode.conquer.sol.graph;

import java.util.HashSet;
import java.util.Set;

/*
 * if the rectangle is valid following conditions have to match:
 * 1.the corner points can only be 4 unique points.
 * 2.all other points: the T-junctions or cross are even numbers meaning 2 or 4. 
 * the total area from each rectangle is equal to the area of the final valid rectangle.
 * if any of the above are not satisfied we return false.
 * see comments below for are above conditions are checked
 * Note, points are not follow by the matrix convention.
 * it starts from bottom left to top right
 * Time O(n) Space O(n)
 */
public class PerfectRectangle {
	public PerfectRectangle() {}

	public boolean isRectangleCover(int[][] rectangles) {
		if(rectangles == null || rectangles.length == 0) return false;
		Set<String> set = new HashSet<>();

		int xl = Integer.MAX_VALUE, yl = Integer.MAX_VALUE, xr = Integer.MIN_VALUE, yr = Integer.MIN_VALUE;

		int area = 0;
		for(int[] rec : rectangles){
			//this will return the final xl,xr,yl,yr for the final big rectangle.
			xl = Math.min(rec[0],xl);
			yl = Math.min(rec[1],yl);
			xr = Math.max(rec[2],xr);
			yr = Math.max(rec[3],yr);

			//adding each rectangle's area
			//top y - bottom y * most right x - most left x
			area += (rec[3]-rec[1])*(rec[2] - rec[0]);
			//x,y points on a given rectangle
			String point1 = rec[0] + " " + rec[1];
			String point2 = rec[2] + " " + rec[3];
			String point3 = rec[0] + " " + rec[3];
			String point4 = rec[2] + " " + rec[1];

			//Set returns true if content exists in set
			if(!set.add(point1)) set.remove(point1);
			if(!set.add(point2)) set.remove(point2);
			if(!set.add(point3)) set.remove(point3);
			if(!set.add(point4)) set.remove(point4);  
		}

		//in the end set should only contains 4 cornor points as all other points in a valid rectangle should be 2 or 4, since
		//they are even should have been removed from the set.
		if(set.size() != 4 || !set.contains(xl+" "+yl) || !set.contains(xl+" "+yr) || !set.contains(xr+" "+yl) || !set.contains(xr+" "+yr)) return false;
		
		//lastly each if all rectangle's are match to area of the big rectangle.
		return area == (xr-xl) * (yr-yl);
	}
}
