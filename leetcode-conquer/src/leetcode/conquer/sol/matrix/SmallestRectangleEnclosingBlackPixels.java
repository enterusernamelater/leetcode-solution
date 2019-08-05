package leetcode.conquer.sol.matrix;

/*
 * This is a pure matrix approache, basically I draw the line from left to right and top
 * to bottom to look for the min rectangle width and length.
 * link below explains the idea pretty well, there is another solution will need to use binary search but I think this
 * is enough for now
 * https://www.youtube.com/watch?v=J9oXzbBUbCs
 *  Time O(m*n) space constant;
 */
public class SmallestRectangleEnclosingBlackPixels {
	public SmallestRectangleEnclosingBlackPixels() {}

	public int minArea(char[][] image, int x, int y) {
		if(image == null || image.length == 0) return -1;
		int m = image.length, n = image[0].length;

		int top = x, bottom = x, left = y, right = y;

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(image[i][j] == '1'){
					top = Math.min(top, i);
					bottom = Math.max(bottom, i + 1);
					left = Math.min(left,j);
					right = Math.max(right,j+1);
				}
			}
		}

		return (right - left) * (bottom - top);
	}
}
