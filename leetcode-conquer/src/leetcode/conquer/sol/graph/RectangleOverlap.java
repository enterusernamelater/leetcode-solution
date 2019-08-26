package leetcode.conquer.sol.graph;

/*
 * this question is the same as the part of finding overlap area
 * in the rectangleArea question, the comments below are copied over from that question too
 * Time constant space constant
 */
public class RectangleOverlap {
	public RectangleOverlap() {}
	
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1 == null || rec1.length == 0 || rec2 == null || rec2.length == 0) return true;
        
		//finding possible overlap points
		//in normal case (no overlap) xl2 > xr1
		//the case below determines if there is overlap on the x axis
		//by taking max on the xl1,xl2 
		//and taking min on the xr1 and xr2 
		//if x axis has no overlap the max of the xl1 and xl2 will be greater than the min of the xr1 and xr2
		//in this case left > right
        int left = Math.max(rec1[0], rec2[0]);
        int right = Math.min(rec1[2],rec2[2]);
        
		//below checks if there is overlap on the y axis
		//same logic as above. in the normal case
		//the max of the yl1 and yl2 will be greater than the min of the yr1 and yr2
		//in this case bottom is greater than top.
        int bottom = Math.max(rec1[1],rec2[1]);
        int top = Math.min(rec1[3], rec2[3]);
        
        return right > left && top > bottom;
    }
}
