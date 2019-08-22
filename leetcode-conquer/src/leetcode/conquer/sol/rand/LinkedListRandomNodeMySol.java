package leetcode.conquer.sol.rand;

import java.util.Random;

import leetcode.conquer.list.ListNode;

/*
 * loop through the list one time find its size
 * the get a random index from the size
 * and then loop through the list again to find the random index and return its value
 * Time O(n) Space constant
 */
public class LinkedListRandomNodeMySol {
	private ListNode head;
	private Random rand = new Random();
	
	/** @param head The linked list's head.
	        Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNodeMySol(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int n=0;
		ListNode dummy = this.head;
		while(dummy != null){
			n++;
			dummy = dummy.next;
		}
		int ran = rand.nextInt(n);

		dummy = this.head;
		for(int i=0;i<ran;i++){
			dummy=dummy.next;
		}

		return dummy.val;
	}
}
