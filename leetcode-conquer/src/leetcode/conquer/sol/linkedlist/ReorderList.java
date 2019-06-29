package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * we first reverse the second half of the linked list
 * then we reorder by connecting the each pair of first and second half node
 * where the 2ndHalfNode.next = 1halfNode.next
 * and 1halfNode.next= 2ndHalfNode.
 * once the connection is established when then cuts off the middle 'slower' to point its next to the 
 * tmp node we stored: ListNode tmp = cur.next; the cur is the current 2ndhalfNode that we just established 
 * the connection to the first half list
 * Time O(N) Space O(1)
 */
public class ReorderList {
	public ReorderList() {}
	
	public void reorderList(ListNode head) {
		if(head == null) return;
		ListNode slow = head;
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast= fast.next.next;
		}

		//reverse the second half
		ListNode prev = null;
		ListNode cur = slow.next;

		while(cur!= null){
			ListNode tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		slow.next = prev;
		//reorder list
		cur = slow.next;
		ListNode start = head;

		while(start != slow){
			ListNode tmp = cur.next;
			cur.next = start.next;
			start.next = cur;
			start = cur.next;
			cur = tmp;
			slow.next = cur;
		}
	}
}
