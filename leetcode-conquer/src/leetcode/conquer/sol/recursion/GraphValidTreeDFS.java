package leetcode.conquer.sol.recursion;

/*
 * this is a dfs solution to check if the given edges will from a valid tree

 * the idea is first we store both vertice on a edge into a table
 * then we do dfs call on the table and using an boolean array to keep track which node is visited
 * during the dfs only the parent of the node can be repeatedly visited any children of the node that is encountered 
 * twice+ visited we have found the circle see comments below
 * 
 * very similar to course schedule question only differences is one is undirected graph another one is directed graph
 * Time O(n) Space O(n)
 */
import java.util.ArrayList;
import java.util.List;

public class GraphValidTreeDFS {
	public GraphValidTreeDFS() {}
	
    public boolean validTree(int n, int[][] edges) {
        int[] visit = new int[n]; //1 is vistiting, 2 is visited;
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<n;i++) map.add(new ArrayList<>());

        for(int[] vals : edges){
            map.get(vals[0]).add(vals[1]);
            map.get(vals[1]).add(vals[0]);
        }
        
        helper(map,n, visit, 0 , -1);
        for(int val : visit) if(val != 2) return false;
        return true;
    }
    
    private boolean helper(List<List<Integer>> map, int n, int[] visit, int index,int parent){
        if(visit[index] == 1) return false;
        if(visit[index] == 2) return true;
        visit[index] = 1;
        
        List<Integer> list = map.get(index);
        for(int i=0;i<list.size();i++){
            if(list.get(i) != parent && !helper(map,n,visit,list.get(i),index)) return false;
        }
        visit[index]=2;
        return true;
    }
}
