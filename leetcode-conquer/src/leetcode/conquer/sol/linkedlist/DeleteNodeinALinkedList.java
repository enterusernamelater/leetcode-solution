package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * remove node by copy the val of its next to itself
 * then points node.next = node.next.next;
 * this means we actually replaced current node with the next nodes value and skipped next node.
 * time o(1) space constant
 */
public class DeleteNodeinALinkedList {
	public DeleteNodeinALinkedList() {}
	
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
