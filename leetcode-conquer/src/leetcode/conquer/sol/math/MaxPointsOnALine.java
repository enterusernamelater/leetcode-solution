package leetcode.conquer.sol.math;

/*
 * use the equation (y3-y2)(x2-x1) =  (y2-y1)(x3-x2)
 * to solve this problem. 
 * really dont feel like explain this question right now..
 * Link below for more detailed explanation:
 * https://www.youtube.com/watch?v=Pr5n7Rw7VI8
 * Time O(n) Space constant
 */
public class MaxPointsOnALine {
	public MaxPointsOnALine() {}
	
	public int maxPoints(int[][] points) {
		int n = points.length;
		if(n<3) return n;
		int max = 2;
		for(int i=1;i<n;i++){
			int count = 0;
			int[] point1 = points[i-1];
			int[] point2 = points[i];
			long x1 = point1[0];
			long y1 = point1[1];
			long x2 = point2[0];
			long y2 = point2[1];

			//if they are duplicate
			if(x1==x2 && y1 == y2){
				for(int j=0;j<n;j++){
					int[] point = points[j];
					if(point[0] == x1 && point[1] == y1){
						count++;
					}
				}
			}else{
				for(int j=0;j<n;j++){
					int[] point = points[j];
					long x3 = point[0];
					long y3 = point[1];
					if((y3-y2) * (x2-x1) == (y2-y1) * (x3-x2)){
						count++;
					}
				}
			}
			max = Math.max(max,count);
		}
		return max;
	}
}
