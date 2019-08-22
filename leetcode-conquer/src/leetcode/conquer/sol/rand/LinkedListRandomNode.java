package leetcode.conquer.sol.rand;

import java.util.Random;

import leetcode.conquer.list.ListNode;

/*
 * This is a reservoir sampling solution that we first set the res=head
 * and on each .next of the head, n increments, and there is a 1/n chance that 
 * the res will be replaced by the current node.
 * to produce 1/n we use nextInt(n) == 0, when nextInt(n) == 0 then this is 1/n chance
 * in the end we return res.val as the final result.
 * Time O(n) space constant
 * link that explains this question can be found here:
 * https://www.youtube.com/watch?v=hiLbawfcMbM
 */
public class LinkedListRandomNode {
	private ListNode head;
	private Random rand = new Random();
	/** @param head The linked list's head.
	        Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode dummy = head;
		ListNode res = head;
		for(int n=1; dummy != null;n++){
			if(rand.nextInt(n) == 0) res = dummy;
			dummy = dummy.next;
		}

		return res.val;
	}
}
