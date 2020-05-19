package leetcode.conquer.sol.design;

import java.util.LinkedList;
import java.util.Queue;

/*
 * the idea is using q and a arr of used
 * when get we the avaliable from q and mark the number as used
 * when release we offer the number back to the q and mark used of the number as false
 * when check avaliable of the number we return if the used[number] is not false 
 * remove on the set is O(1)
 * Time O(1) on all function
 * Space O(n)
 */
public class DesignPhoneDirectory {
	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	private boolean[] used;
	private Queue<Integer> q = new LinkedList<>();
	public DesignPhoneDirectory(int maxNumbers) {
		this.used = new boolean[maxNumbers];
		for(int i=0;i<maxNumbers;i++) q.offer(i);
	}

	/** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
	public int get() {
		if(q.isEmpty()) return -1;
		int val = q.poll();
		used[val] = true;
		return val;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return !used[number];
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if(!used[number]) return;
		q.offer(number);
		used[number] = false;
	}
}
