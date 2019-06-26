package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * 
 * Floyd's cycle-finding algorithm,
 * Time O(n) Space O(1)
 * a detailed explanation vid can be find in here
 * https://www.youtube.com/watch?v=LUm2ABqAs1w
 */
 
public class LinkedListCycleII {
	
	public LinkedListCycleII() {}
	
	public ListNode detectCycle(ListNode head) {
		ListNode runner = head;
		ListNode walker = head;

		while(runner != null && runner.next != null){
			walker = walker.next;
			runner = runner.next.next;

			if(walker == runner){
				ListNode slow = head;
				while(slow != walker){
					slow = slow.next;
					walker = walker.next;
				}
				return walker;
			}
		}
		return null;
	}
}
