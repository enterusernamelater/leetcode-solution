package leetcode.conquer.sol.design;

import java.util.LinkedList;
import java.util.Queue;

/*
 * use queue if queue max out we poll the val - the sum
 * and add the new val with the sum and add the new val in queue
 * and return the sum/q.size()
 * Time O(1) Space O(n) n is the cap size
 */
public class MovingAverageFromDataStream {
	private Queue<Integer> q;
	private int cap;
	private double sum = 0;
	/** Initialize your data structure here. */
	public MovingAverageFromDataStream(int size) {
		this.q = new LinkedList<>();
		this.cap = size;
	}

	public double next(int val) {
		if(q.size() == cap){
			sum -= q.poll();
		}
		sum+=val;
		q.offer(val);

		return sum/q.size();
	}
}
