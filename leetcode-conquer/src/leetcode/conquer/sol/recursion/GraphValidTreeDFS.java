package leetcode.conquer.sol.recursion;

/*
 * this is a dfs solution to check if the given edges will from a valid tree
 * the idea is first we store both vertice on a edge into a table
 * then we do dfs call on the table and using an boolean array to keep track which node is visited
 * during the dfs only the parent of the node can be repeatedly visited any children of the node that is encountered 
 * twice+ visited we have found the circle see comments below
 * Time O(n) Space O(n)
 */
import java.util.ArrayList;
import java.util.List;

public class GraphValidTreeDFS {
	public GraphValidTreeDFS() {}
	
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> table = new ArrayList<>();
        for(int i=0;i<n;i++) table.add(new ArrayList<>());
        
        for(int[] edge : edges){
            table.get(edge[0]).add(edge[1]);
            table.get(edge[1]).add(edge[0]);
        }
        
        boolean[] v = new boolean[n];
        if(dfs(table,v,0,0)) return false;
        
        //all vertices should be visited if not we don't have  tree because tree is connected.
        for(boolean i : v) if(!i) return false;
        return true;
    }
    
    private boolean dfs(List<List<Integer>> table, boolean[] v, int node, int parent){
        v[node] = true;
        
        //we have to skip parent in the loop so because the graph is un-directed meaning both way.
        //so we the node viste back to the parent we simpily skip.
        for(int i : table.get(node)){
            //if the node is visted and is not the parent the we have circle.
            //if we havent visited the node we continue, in this case we only parent should be visted and skipped 
            if((v[i] && i != parent) || (i != parent && dfs(table,v,i,node))) return true;
        }
        
        return false;
    }
}
