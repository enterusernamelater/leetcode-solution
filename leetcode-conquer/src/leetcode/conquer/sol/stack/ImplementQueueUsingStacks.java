package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * pop stack vals from one to the another and after we add the stack val to the first stack
 * we then pop everything back
 * Time O(n), Space(n)
 */
public class ImplementQueueUsingStacks {
    Deque<Integer> s1;
    Deque<Integer> s2;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        this.s1 = new ArrayDeque<>();
        this.s2 = new ArrayDeque<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!s1.isEmpty()) s2.push(s1.pop());
        s1.push(x);
        while(!s2.isEmpty()) s1.push(s2.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
