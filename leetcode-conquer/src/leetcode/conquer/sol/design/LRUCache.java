package leetcode.conquer.sol.design;

import java.util.HashMap;
import java.util.Map;

/*
 * The double link list acts as a tracker array, every time a node is accessed
 * the node is moved to the last, we always remove the first node which is the least recent node.
 * we use a hashMap to keep track the nodes in the double linked list for update/get the list node, so 
 * we don't have to traverse the double linked list to avoid the O(N) hits.
 * like said, when the max capacity reached we remove the first node from head.next
 * when moving a node to the last(the recent accessed one by either get or put)
 * we change the pointers of node's next/pre and dummy tail's next/prev
 * we then remove the node by re-pointing the node's prev and next.

 * Time O(1) on both get and put and Space is O(n)
 */
public class LRUCache {
	private int max;
	private Map<Integer,ListNode> map;
	private ListNode head;
	private ListNode tail;

	public LRUCache(int capacity) {
		this.max = capacity;
		this.map = new HashMap<>();
		this.head = new ListNode();
		this.tail = new ListNode();
		//initialize the double linked list
		head.next =tail;
		tail.prev = head;
	}

	public int get(int key) {
		if(!map.containsKey(key)) return -1;
		ListNode node = map.get(key);
		updateNodeToTheLast(node);

		return node.val;
	}

	public void put(int key, int value) {
		if(map.containsKey(key)){
			updateNode(map.get(key),value);
			return;
		}
		if(map.size() == max) removeNode(map.get(head.next.key));
		addNode(key,value);
	}

	private void addNode(int key, int value){
		ListNode node = new ListNode(key,value,tail.prev,tail);
		tail.prev.next = node;
		tail.prev = node;

		map.put(key,node);
	}

	private void updateNode(ListNode node, int value){
		node.val = value;
		updateNodeToTheLast(node);
	}

	private void removeNode(ListNode node){
		ListNode next = node.next;
		head.next = next;
		next.prev = head;

		map.remove(node.key);
	}

	private void updateNodeToTheLast(ListNode node){
		node.prev.next = node.next;
		node.next.prev = node.prev;

		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;
	}


	class ListNode {
		public int key;
		public int val;
		public ListNode prev;
		public ListNode next;

		public ListNode(){
			this.key = 0;
			this.val= 0;
		}
		public ListNode(int key, int val, ListNode prev, ListNode next){
			this.key = key;
			this.val = val;
			this.prev = prev;
			this.next = next;
		}
	}
}
