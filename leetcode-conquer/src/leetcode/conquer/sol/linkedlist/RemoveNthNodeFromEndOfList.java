package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * o(n) one pass, always maintain n nodes between start and end and move start 
 * and end pointers forward until end reaches to the end of the list
 * start will land before the remove node n.
 * very elegant solution
 */
public class RemoveNthNodeFromEndOfList {
	public RemoveNthNodeFromEndOfList() {}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}
}
