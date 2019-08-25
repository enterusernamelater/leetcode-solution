package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * brute force..not prund of myself..
 * find all combs see if they sum up to 0 if so
 * re-point the previous and curr pointers to skip the sum = 0 part
 * Time(n^2) Space constant
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

	public RemoveZeroSumConsecutiveNodesFromLinkedList() {};

	public ListNode removeZeroSumSublists(ListNode head) {
		if(head == null) return head;
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode cur = head;
		ListNode prev = dummyNode;

		while(cur != null){
			//remove 0 for special case
			if(cur.val == 0){
				prev.next = cur.next;
				cur = cur.next;
				continue;
			}

			int sum = cur.val;
			ListNode dummy = cur.next;
			while(dummy != null){
				sum+=dummy.val;
				if(sum == 0){
					prev.next = dummy.next;
					cur = dummy.next;
				}
				dummy = dummy.next;
			}

			prev = cur;
			if(cur!= null) cur = cur.next;
		}

		return dummyNode.next;
	}
}
