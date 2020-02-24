package leetcode.conquer.sol.math;

/*
 * the idea is find all pair of points and looking though all given points see if their slope is the same 
 * (y2-y1)*(x3-x2) == (x2-x1) *(y3-y2) if so we found a line, while during the check on the slop
 * we keep a counter on the number of points that have the same slop and update the result with the max 
 * we also need to consider the duplicate points to i, we have a separate counter dup to count the duplicate points
 * to point1 on i index.
 * 
 * in the end the total points on point1 and point2 will be all points having a same slope to p1 and p2 plus the number of duplicates
 * to point1. Note that when a duplicate happens on point2 (y2-y1)*(x3-x2) == (x2-x1) *(y3-y2) becomes 0 = 0 so the duplicate count
 * will be added to the slope counter count on behalf of the duplicate point to point2. 
 * Time O(n^3)
 * space constant
 */
public class MaxPointsOnALine {
	public MaxPointsOnALine() {}

	public int maxPoints(int[][] points) {
		if(points == null || points.length == 0) return 0;
		if(points.length < 3) return points.length;
		
		int res = 0;
		
		for(int i=0;i<points.length;i++){
			int dup = 0;
			for(int j=i+1;j<points.length;j++){
				int[] point1 = points[i];
				int[] point2 = points[j];
				long x1 = point1[0];
				long x2 = point2[0];
				long y1 = point1[1];
				long y2 = point2[1];
				
				if(x1 == x2 && y1 == y2){
					//record duplicates plus the original i
					//this is to handle the speical case when all given points are duplicates
					res = Math.max(res,++dup + 1);
					continue;
				}

				int count = 2; // starting off 2: p1 and p2
				for(int k=j+1;k<points.length;k++){
					long x3 = points[k][0];
					long y3 = points[k][1];

					//find the slope that belongs two point1 and point2
					if((y2-y1)*(x3-x2) == (x2-x1) *(y3-y2)) count++;
				}
				
				//in the end we find the max between res and count + all duplicates to p1. no need to add original i because count already includes it
				res = Math.max(res,count + dup);
			}
		}
		return res;
	}
}
