package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * detailed explanation can be found in this link's 2nd sol
 * https://www.youtube.com/watch?v=pLx1VP-FnuY
 * Time O(n) space o(1) constant
 */
public class ReverseNodesInKGroup {
	public ReverseNodesInKGroup() {}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null) return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;

		while(prev != null){
			ListNode last = prev;
			for(int i=0;i<=k;i++){
				last = last.next;
				if(last == null){
					if(i<k) return dummy.next;
					break;
				}
			}
			ListNode tail = prev.next;
			ListNode cur = tail.next;

			while(cur != last){
				ListNode tmp = cur.next;
				cur.next = prev.next;
				prev.next = cur;
				tail.next = tmp;
				cur = tmp;
			}
			prev = tail;
		}
		return dummy.next;
	}
}
