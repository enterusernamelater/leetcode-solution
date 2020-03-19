package leetcode.conquer.sol.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignAStackWithIncrementOperation {
	 private int max;
	    private Deque<Integer> stack = new ArrayDeque<>();
	    public DesignAStackWithIncrementOperation(int maxSize) {
	        this.max = maxSize;
	    }
	    
	    //ignore if the max size reached.
	    public void push(int x) {
	        if(stack.size() < max) stack.push(x);
	    }
	    
	    //return -1 if size empty
	    public int pop() {
	        return stack.isEmpty()? -1 : stack.pop();
	    }
	    
	    //use a second stack to store all vals in stack first and increment all first k vals in second stack
	    //then dump all remaining vals from the second stack to the first stack
	    public void increment(int k, int val) {
	        Deque<Integer> stack2 = new ArrayDeque<>();
	        while(!stack.isEmpty())stack2.push(stack.pop());
	        while(k>0 && !stack2.isEmpty()){
	            stack.push(stack2.pop()+val);
	            k--;
	        }
	        
	        while(!stack2.isEmpty()) stack.push(stack2.pop());
	    }
}
