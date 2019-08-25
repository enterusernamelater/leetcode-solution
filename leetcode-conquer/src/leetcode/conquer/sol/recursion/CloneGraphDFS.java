package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.conquer.tree.Node;

/*
 * in dfs, if map contains no val, we add the val with new list into the map and we dfs the current node's neighbors
 * if the the neighbor is already in the map we get the neighbor from the map and add to the current val's list. If the neighbor is not in the map, we add the neighbor to the map and dfs the neighbor's neighbors follow the same logic.
 * in the end when all nodes are in the map, the nodes' neighbors will be filled through recursion.
 * Time O(N!) Space O(n)
 */
public class CloneGraphDFS {
    private Map<Integer,Node> map = new HashMap<>();
    
    public CloneGraphDFS() {}
    
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        helper(node);
        
        return map.get(node.val);
    }
    
    private void helper(Node node){
        if(map.containsKey(node.val)) return;
        
        Node res = new Node(node.val, new ArrayList<>());
        map.put(res.val,res);
        
        List<Node> list = res.neighbors;
        
        for(Node tmp : node.neighbors){
            helper(tmp);
            list.add(map.get(tmp.val));
        }
    }
}
