package leetcode.conquer.sol.queue.priority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * this question is basically finding a valid path in the eulerian path using hierholzer's algorithm
 * when performing hierholzer's algorithm, we only viste each path and remove by using priorityqueue poll
 * using priorityqueue to sort each departure ticket's destination to obey the lexical order
 * Time O(n+nlog(n)) the n is looping through each ticket, nlogn is we sort the destination on each departure
 * Space O(n)
 * link below explains this question in detail:
 * https://www.youtube.com/watch?v=LKSdX31pXjY
 */
public class ReconstructItinerary {
	public ReconstructItinerary() {}
	
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return null;
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(List<String> ticket : tickets){
           PriorityQueue<String> q = map.getOrDefault(ticket.get(0), new PriorityQueue<>());
           q.offer(ticket.get(1));
           map.putIfAbsent(ticket.get(0),q);
        }
        
        List<String> res = new ArrayList<>();

        dfs("JFK",res,map);
        return res;
    }
    
    private void dfs(String start, List<String> res, Map<String, PriorityQueue<String>> map){
        PriorityQueue<String> q = map.get(start);
        
        while(q != null && !q.isEmpty()){
            dfs(q.poll(),res,map);
        }
        
        res.add(0,start);
    }
}
