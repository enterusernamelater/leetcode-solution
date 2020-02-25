package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * everything else the same stack functions but when pop if we pop the min
 * then we loop through the remaining stack find a new min
 * doing so by dump all vals to the stack2 and after min is calculated
 * dump stack2 back to stack 1;
 */
public class MinStackMySol {

	private Deque<Integer> stack1;
	private Deque<Integer> stack2;
	private Integer min = Integer.MAX_VALUE;
	/** initialize your data structure here. */
	public MinStackMySol() {
		this.stack1 = new ArrayDeque<>();
		this.stack2 = new ArrayDeque<>();
	}
	//o(1)
	public void push(int x) {
		min = Math.min(x,min);
		stack1.push(x);
	}

	//o(n)
	public void pop() {
		int val = stack1.pop();
		if(val != min) return;

		min = Integer.MAX_VALUE;
		while(!stack1.isEmpty()){
			val = stack1.pop();
			min = Math.min(min,val);
			stack2.push(val);
		}

		while(!stack2.isEmpty())stack1.push(stack2.pop());
	}

	//o(1)
	public int top() {
		return stack1.peek();
	}

	//o(1)
	public int getMin() {
		return min;
	}
}
