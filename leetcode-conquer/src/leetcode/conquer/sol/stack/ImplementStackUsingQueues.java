package leetcode.conquer.sol.stack;

import java.util.LinkedList;
import java.util.Queue;

/*
 * pretty easy solution that using two queues to implement this stack
 * find the empty queue and offer the x and then poll all the vals from other queue to the queue
 * offered x.
 * Time O(n) on push, Space O(n)
 */
public class ImplementStackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {}
    
    /** Push element x onto stack. */
    public void push(int x) {
        while(!q1.isEmpty()) q2.offer(q1.poll());
        q1.offer(x);
        while(!q2.isEmpty()) q1.offer(q2.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
