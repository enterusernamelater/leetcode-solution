package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;


/*
 * a solution that while pushes val into the stack we also keep a second min before the min
 * everytime we min changes value. and when we pop if the min is the pop we also pop the second min and
 * update the second min to the min.
 * getMin time complexity is constant
 * space O(n)
 * 
 * Note..Integer is an object dont use == to compare. 
 */
public class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private int min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }
    
    public void pop() {
       if(min == stack.pop()) min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
