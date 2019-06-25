package leetcode.conquer.sol.array;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * this solution uses stack to reduce the time complexity from O(n^2) in sol one to O(n)
 * space o(n)
 * detailed explanation in link below:
 * https://www.youtube.com/watch?v=KkJrGxuQtYo
 */
public class LargestRectangleInHistogramSolTwo {
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
