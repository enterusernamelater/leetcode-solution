package leetcode.conquer.sol.array;

/*
 * This is one of the solution with Time O(n^2) space O(1)
 * detailed explanation is in the video below:
 * https://www.youtube.com/watch?v=KkJrGxuQtYo
 */
public class LargestRectangleInHistogramSolOne {
	public LargestRectangleInHistogramSolOne() {}
	
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length ==0) return 0;

        int res = 0;
        for(int i=0;i<heights.length;i++){
            if(i == heights.length-1 || heights[i] > heights[i+1]){
                int min = Integer.MAX_VALUE;
                for(int j=i;j>=0;j--){
                    int w = i-j+1;
                    min = Math.min(min,heights[j]);
                    res = Math.max(res, min*w);
                }
            }
        }
        return res;
    }
}
