package leetcode.conquer.sol.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * we first sort the events by its start day
 * through greedy solution we need to make sure each day (from events offered min day to max day)
 * we can attain one event;
 * use priority queue for the second sort on the end of each event happening on that same day
 * we poll the event from the priority queue if the event's end day passed the current day 
 * if we still have events within the priority queue that their ending day is greater or equal to the current d
 * we poll one out of the pq, this one will be the ends the quickest thanks to the priority queue auto sort
 * and we increment the result by 1
 * 
 * Logic above continues;
 * 
 * Time O(nlog(n)) because of the sort
 * Space O(n)
 */
public class MaximumNumberOfEventsThatCanBeAttended {
	public MaximumNumberOfEventsThatCanBeAttended() {}

	public int maxEvents(int[][] events) {
		if(events == null || events.length ==0) return 0;
		Arrays.sort(events,(a,b) -> a[0] != b[0]? a[0] - b[0] : a[1] - b[1]);

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int i=0, res =0, n = events.length;
		for(int d=1; d<=100000 && (i < n || !pq.isEmpty()); d++){
			while(i< n && events[i][0] == d){
				pq.offer(events[i++][1]);
			}
			while(!pq.isEmpty() && pq.peek()<d) pq.poll();
			if(!pq.isEmpty()){
				pq.poll();
				res++;
			}
		}

		return res;
	}
}
