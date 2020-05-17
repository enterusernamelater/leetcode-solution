package leetcode.conquer.sol.design;

import java.util.PriorityQueue;

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
    private PriorityQueue<Integer> q = new PriorityQueue<>();
    public DesignHitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >=300){
            q.poll();
        }
        return q.size();
    }
}
