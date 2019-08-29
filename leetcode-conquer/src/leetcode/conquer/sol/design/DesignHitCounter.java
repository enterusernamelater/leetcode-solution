package leetcode.conquer.sol.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * the idea is to use a queue to store all the seconds that hits happened.
 * a map keeps track at a given sec how many hit are there.
 * we clear the queue and map when a next hit is passed 5 min
 * when get hits we first remove any stored secs thats outside of the current timestamp - 5mins windows
 * while clear the queue we also clear the map keys thats outside the current timestamp as well
 * after that we sum up map's value sum as the value keeps track how many hits for a given sec
 * Time O(1) on hit  O(n) on get. 
 * Space O(n) n is the hits happening within the 5 mins.
 */
public class DesignHitCounter {
	private Queue<Integer> q;
	private Map<Integer,Integer> map; // this map is needed to count number of hits when all happening within a sec
	/** Initialize your data structure here. */
	public DesignHitCounter() {
		this.q = new LinkedList<>();
		this.map = new HashMap<>();
	}

	/** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
	public void hit(int timestamp) {
		if(map.containsKey(timestamp)){
			map.put(timestamp, map.get(timestamp) + 1);
			return;
		}

		while(!q.isEmpty() && timestamp - q.peek() >=300) map.remove(q.poll());
		map.put(timestamp,1);
		q.offer(timestamp);
	}

	/** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
	public int getHits(int timestamp) {
		while(!q.isEmpty() && timestamp - q.peek() >=300) map.remove(q.poll());
		int res = 0;
		for(int i : map.values()) res+=i;
		return res;
	}
}
