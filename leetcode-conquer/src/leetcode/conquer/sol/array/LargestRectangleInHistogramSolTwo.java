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
	
	//a better written solution from leetcode, credit to: jeantimex
	public int largestRectangleAreaSolTwo(int[] h) {
		  int n = h.length, i = 0, max = 0;
		    
		  Deque<Integer> s = new ArrayDeque<>();
		    
		  while (i < n) {
		    // as long as the current bar is shorter than the last one in the stack
		    // we keep popping out the stack and calculate the area based on
		    // the popped bar
		    while (!s.isEmpty() && h[i] < h[s.peek()]) {
		      // tricky part is how to handle the index of the left bound
		      max = Math.max(max, h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
		    }
		    // put current bar's index to the stack
		    s.push(i++);
		  }
		    
		  // finally pop out any bar left in the stack and calculate the area based on it
		  while (!s.isEmpty()) {
		    max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
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
