package leetcode.conquer.sol.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * the solution handles kvector case where zigzag becomes Cyclic 
 * add all list iterator into queue and pop one with its val one at a time
 * if the iterator still has next add the iterator back to the queue as queue is FIFO the 
 * add back on will be placed on its last.
 * Time O(n) Space O(n)
 */
public class ZigzagIteratorKVector implements Iterator<Integer>{
	public ZigzagIteratorKVector() {}
	
    private Queue<Iterator<Integer>> q;

    public ZigzagIteratorKVector(List<Integer> v1, List<Integer> v2) {
        this.q = new LinkedList<>();
        if(!v1.isEmpty()) q.offer(v1.iterator());
        if(!v2.isEmpty()) q.offer(v2.iterator());
    }

    public Integer next() {
        Iterator<Integer> v = q.poll();
        int res = v.next();
        if(v.hasNext()) q.offer(v);
        return res;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}
