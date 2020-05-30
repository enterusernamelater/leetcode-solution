package leetcode.conquer.sol.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * basically dfs traverse the graph and putting each edge's each side of the node into two subset
 * when two subset is about to have a same node we know we cant have bipartite so we return
 * Time O(n)
 * Space O(n)
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];

        map.put(0,new HashSet<>());
        map.put(1,new HashSet<>());
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(i,1,graph,map,visited)) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int n, int level, int[][] graph, Map<Integer,Set<Integer>> map, boolean[] visited){  
        //when a node is visited that means it is already belong to a sub set from another edge.
        //therefore if current sub set contains no such node on this edge, 
    	//that means we know we are about to add this edge's node into another set
        //since both set will have this node we know the graph bipartite is not possible
        if(visited[n] && !map.get(level%2).contains(n)) return true;
        if(visited[n]) return false;
        visited[n] = true;
        map.get(level%2).add(n);
        for(int node : graph[n]){
            if(dfs(node,level+1,graph,map,visited)) return true;
        }
        
        return false;
    }
}
