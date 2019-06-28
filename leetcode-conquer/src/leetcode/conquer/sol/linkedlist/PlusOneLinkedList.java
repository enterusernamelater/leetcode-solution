package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * A recursive sol that returns the offset on each recursive call
 * also using a dummy for cornor case where a offset happens on the most significant bits
 * so we will need to extend the 1 to the dummy node
 * Time O(n), Space O(1)
 */
public class PlusOneLinkedList {
	public PlusOneLinkedList() {}

	public ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode start = dummy;
		helper(start);
		return dummy.val > 0? dummy : dummy.next;
	}

	private int helper(ListNode node){
		if(node.next == null){
			int val = node.val + 1;
			int offset = val/10;
			node.val = val%10;
			return offset;
		}

		int offset = helper(node.next);

		int val = node.val + offset;
		node.val = val % 10;

		return val/10;
	}
}
