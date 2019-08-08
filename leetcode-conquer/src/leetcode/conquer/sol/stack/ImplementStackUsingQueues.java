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
	private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public ImplementStackUsingQueues() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(q1.isEmpty()){
            q1.offer(x);
            while(!q2.isEmpty()) q1.offer(q2.poll());
        }else if(q2.isEmpty()){
            q2.offer(x);
            while(!q1.isEmpty()) q2.offer(q1.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return !q1.isEmpty()? q1.poll() : q2.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return !q1.isEmpty()? q1.peek() : q2.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
