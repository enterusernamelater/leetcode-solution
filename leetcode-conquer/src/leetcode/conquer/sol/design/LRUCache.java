package leetcode.conquer.sol.design;

import java.util.HashMap;
import java.util.Map;

/*
 * The double link list acts as a tracker array, every time a node is accessed
 * the node is moved to the first, we always remove the last node which is the least recent node.
 * we use a hashMap to keep track the nodes in the double linked list for update/get the list node, so 
 * we don't have to traverse the double linked list to avoid the O(N) hits.
 * like said, when the max capacity reached we remove the last node from dummy tail previous. 
 * when moving a node to the first(the recent accessed one by either get or put)
 * we change the pointers of node's next/prev and dummy head's next/prev
 * we then remove the node by re-pointing the node's prev and next.
 * also we have a size val to keep track the size of the map so we don't need to call map.size() for a o(n) hit.
 * Time O(1) on both get and put and Space is O(n)
 * link to this problem:
 * https://www.youtube.com/watch?v=S6IfqDXWa10
 */
public class LRUCache {
	private Map<Integer,ListNode> map;
	private ListNode dh;
	private ListNode dt;
	private int max;
	private int size;
	
	public LRUCache(int capacity) {
		this.max = capacity;
		this.map = new HashMap<>();
		this.dh = new ListNode(-1,-1);
		this.dt = new ListNode(-1,-1);
		dh.next = dt;
		dt.prev = dh;
		this.max = capacity;
		this.size = 0;
	}

	public int get(int key) {
		if(!map.containsKey(key)) return -1;
		ListNode res = map.get(key);
		removeNode(res);
		moveFirst(res);
		return res.val;
	}

	public void put(int key, int value) {
		if(map.containsKey(key)){
			ListNode node = map.get(key);
			removeNode(node);
			node.val = value;
			moveFirst(node);
			return;
		}

		if(size == max){
			map.remove(dt.prev.key);
			ListNode last = dt.prev;
			removeNode(last);
			size--;
		}

		ListNode newNode = new ListNode(key,value);
		map.put(key,newNode);
		size++;
		moveFirst(newNode);
	}

	private void moveFirst(ListNode node){
		node.next = dh.next;
		dh.next.prev = node;
		dh.next = node;
		node.prev = dh;
	}

	private void removeNode(ListNode node){
		ListNode prev = node.prev;
		ListNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	class ListNode {
		public int key;
		public int val;
		public ListNode next;
		public ListNode prev;
		public ListNode(int key, int val) { 
			this.key = key; 
			this.val = val;
		}
	}
}
