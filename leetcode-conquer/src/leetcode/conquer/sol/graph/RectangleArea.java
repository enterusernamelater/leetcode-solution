package leetcode.conquer.sol.graph;

/*
 * the final area will two rectangle's area - the overlap. see below comments on how the overlap is calculated
 * Time O(1) Space O(1)
 */
public class RectangleArea {
	public RectangleArea() {}

	public int computeArea(int xl1, int yl1, int xr1, int yr1, int xl2, int yl2, int xr2, int yr2) {
		int area1 = (yr1-yl1) * (xr1-xl1);
		int area2 = (yr2-yl2) * (xr2-xl2);

		//finding possible overlap points
		//in normal case (no overlap) xl2 > xr1
		//the case below determines if there is overlap on the x axis
		//by taking max on the xl1,xl2 
		//and taking min on the xr1 and xr2 
		//if x axis has no overlap the max of the xl1 and xl2 will be greater than the min of the xr1 and xr2
		//in this case left > right
		int left = Math.max(xl1,xl2);
		int right = Math.min(xr1,xr2);

		//below checks if there is overlap on the y axis
		//same logic as above. in the normal case
		//the max of the yl1 and yl2 will be greater than the min of the yr1 and yr2
		//in this case bottom is greater than top.
		int bottom = Math.max(yl1,yl2);
		int top = Math.min(yr1,yr2);

		//if both condition is not satisified we have a overlap
		//overlap area
		int area3 = 0;
		if(left<right && bottom < top){
			area3 = (right-left) * (top - bottom);
		}

		//the final area will be area1 + area2 minus the overlap
		return area1+area2-area3;
	}
}
