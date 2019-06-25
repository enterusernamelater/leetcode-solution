package leetcode.conquer.sol.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * this sol is based on the leetcode 84. we build histogram arr on each row and find the max 
 * area using the 84 sol. the only dp part is when we are building the histogram arr
 * Time O(h*w) space o(w)
 * detailed explanation in this link:
 * https://www.youtube.com/watch?v=2Yk3Avrzauk
 */
public class MaximalRectangle {
	public MaximalRectangle() {}

	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0) return 0;
		int h = matrix.length;
		int w = matrix[0].length;

		int[] heights = new int[w];
		int max = 0;

		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				heights[j] = matrix[i][j] == '1'? ++heights[j] : 0;
			}
			max = Math.max(max, largestRectangleArea(heights));
		}
		return max;
	}

	public int largestRectangleArea(int[] heights) {
		Deque<Integer> stack = new ArrayDeque<>();
		int max = 0;

		for(int i=0; i<heights.length; i++){
			if(stack.isEmpty() || heights[i]>heights[stack.peek()]){
				stack.push(i);
			}else{
				int rMost = i;
				int curr = stack.pop();
				while(!stack.isEmpty() && heights[stack.peek()] == heights[curr]){
					curr = stack.pop();
				}
				int lMost = stack.isEmpty()? -1 : stack.peek();
				max = Math.max(max , (rMost-lMost-1)*heights[curr]);
				i--;
			}
		}

		if(stack.isEmpty()) return max;

		int rMost = stack.peek()+1;
		while(!stack.isEmpty()){
			int curr = stack.pop();
			int lMost = stack.isEmpty()? -1 : stack.peek();
			max = Math.max(max , (rMost-lMost-1)*heights[curr]);
		}

		return max;
	}
}
