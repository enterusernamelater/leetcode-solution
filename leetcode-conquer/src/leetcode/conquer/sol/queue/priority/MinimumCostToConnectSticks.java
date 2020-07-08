package leetcode.conquer.sol.queue.priority;

import java.util.PriorityQueue;

/*
 * pop two smallest stick and sum them up add to the cost and continue
 * always pop the smallest stick to min the cost
 * when the q is size 1 we found the result
 * Time O(nlog(n)) space O(n)
 */
public class MinimumCostToConnectSticks {
	public MinimumCostToConnectSticks() {}
	
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int val : sticks) q.offer(val);
        int cost = 0;
        while(!q.isEmpty()){
            int sum1 = q.poll();
            if(q.isEmpty()) return cost;
            int sum2 = q.poll();
            cost+=sum1+sum2;
            q.offer(sum1+sum2);
        }
        
        return -1;
    }
}
