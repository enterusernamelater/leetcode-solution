package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * tarjan algorithm, using a timer records the time entering dfs on each node. backtrack the min recorded time when cycle reaches the end
 * which is the start of the cycle. when the back tracked cycle time is greater than current node's recorded time we know we found a cycle area
 * that is connected to the current node. therefore we store the result
 * link on tarjan algorithm https://www.youtube.com/watch?v=wUgWX0nc4NY
 * Time O(n)
 * Space O(n)
 */
public class CriticalConnectionsInANetwork {
	public CriticalConnectionsInANetwork() {}
	
    int time = 0;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if(n == 0 || connections == null || connections.size() == 0) return new ArrayList<>();
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        
        for(List<Integer> list : connections){
            graph.get(list.get(0)).add(list.get(1));
            graph.get(list.get(1)).add(list.get(0));
        }

        int[] visit = new int[n];
        int[] records = new int[n]; //use this to find new cycle on visiting node
        
        for(int i=0;i<n;i++){
            if(visit[i] == 2) continue;
            dfs(i,-1,visit,records,graph);
        }
        
        return res;
    }
    
    private Integer dfs(int n, int parent, int[] visit, int[] records, List<List<Integer>> graph){
        if(visit[n] == 1){
            return records[n]; 
        }
        records[n] = ++time;
        
        visit[n] = 1;
        int minlink = Integer.MAX_VALUE;
        for(Integer node : graph.get(n)){
            if(visit[node] == 2 || node == parent) continue;
            int nodeTime = dfs(node,n,visit,records, graph);
            
            if(nodeTime > records[n]){
                res.add(Arrays.asList(n,node));
            }
            
            minlink = Math.min(minlink,nodeTime);   
        }
        visit[n] = 2;
        return minlink;
    }
}
