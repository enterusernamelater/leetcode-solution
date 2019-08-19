package leetcode.conquer.sol.queue.priority;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.conquer.sol.recursion.util.NestedInteger;

/*
 * using queue to expand the nestedIterator. 
 * if is integer we offer to queue, if not wo recursively call addAll until the nest is opened then we add to queue
 * queue is FIFO so the first one offered in will always be the frist one out
 * 
 * Time O(n) Space O(n)
 * link: https://www.youtube.com/watch?v=oXm1Ifivwj4
 * detailed explanation
 */
public class NestedIterator implements Iterator<Integer> {

	public NestedIterator() {}
	
    private Queue<Integer> q;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.q = new LinkedList<>();
        addAll(nestedList);
    }
    
    private void addAll(List<NestedInteger> nestedList){
        for(NestedInteger nest : nestedList){
            if(nest.isInteger()){
                this.q.offer(nest.getInteger());
            }else{
                addAll(nest.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !this.q.isEmpty();
    }
}
