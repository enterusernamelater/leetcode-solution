package leetcode.conquer.sol.linkedlist;

import java.util.HashMap;
import java.util.Map;

import leetcode.conquer.tree.Node;

/*
 * this solution is from the leetcode solution that requires
 * a soild fundtion of memeory referencing and deep and shallow copy
 * we first deep copy all next node. while deep copying them we store them nodes in a hashmap with the old node val as the key
 * so when we reversing back to rebuild the deep copy list, the random node can be found by the hashmap.
 * also if the random node's next/random is null, dont worry because the random node's next/random will be build by the recursion
 * because of the references build through recursion.
 * Time O(n) Space O(n)
 */
public class CopyListWithRandomPointer {
	private Map<Integer, Node> map = new HashMap<>();

	public Node copyRandomList(Node head) {
		if(head == null) return null;

		//this is for the random pointers
		if(map.containsKey(head.val)){
			return map.get(head.val);
		}

		Node node = new Node(head.val,null,null);
		map.put(head.val,node);

		node.next = copyRandomList(head.next);
		node.random = copyRandomList(head.random);

		return node;
	}
}
