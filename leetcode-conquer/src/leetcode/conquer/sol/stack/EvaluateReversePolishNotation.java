package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * basic stack question really nothing to say..just pop two if we encounter +,-,/,* and pop back in the calculated val
 * Time O(n), Space O)(n)
 */
public class EvaluateReversePolishNotation {
	public EvaluateReversePolishNotation() {}

	public int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length == 0) return 0;
		int n = tokens.length;
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i=0; i<n; i++){
			if(tokens[i].equals("-")){
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2-val1);
			}else if(tokens[i].equals("+")){
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2+val1);
			}else if(tokens[i].equals("*")){
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2*val1);
			}else if(tokens[i].equals("/")){
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2/val1);
			}else{
				stack.push(Integer.valueOf(tokens[i]));
			}
		}

		return stack.pop();
	}
}
