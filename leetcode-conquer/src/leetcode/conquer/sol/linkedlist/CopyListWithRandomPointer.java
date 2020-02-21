package leetcode.conquer.sol.linkedlist;

import java.util.HashMap;
import java.util.Map;

import leetcode.conquer.tree.Node;

/*
 * use the original node's memory location as the key
 * loop through the linkedlist copy each node and point the copy's next to another copy of original's next
 * both copy and the copy next will be added to the map. so when we move to the next original node
 * the next original node is already in the map as we created it from the copy of the previous.
 * exception for the beginning we need to create both
 * once all nodes are linked, back track to point the random node of the copy by get on the map's original node's random's memory location
 * by this time all original node's memory location will have its copy and stored in the map.
 * 
 * Time O(N)
 * Space o(N)
 *
 * Time O(n) Space O(n)
 */
public class CopyListWithRandomPointer {
	
    public Node copyRandomList(Node head) {
        //the key is the original node's memory location
        Map<Node,Node> map = new HashMap<>();
        helper(head, map);
        return map.get(head);
    }
    
    private void helper(Node head, Map<Node,Node> map){
        if(head == null) return;
        
        Node node1 = map.getOrDefault(head, new Node(head.val));
        Node node2 = head.next == null? null : new Node(head.next.val);
        node1.next = node2;
        map.putIfAbsent(head,node1);
        map.put(head.next,node2);
        
        helper(head.next,map);
        node1.random = map.get(head.random);
        
    }
}
