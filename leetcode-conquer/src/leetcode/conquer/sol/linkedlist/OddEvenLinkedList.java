package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * Time O(n) Space O(1)
 * by connecting odd with the one after, same goes to even 
 * trick is how we connect odd and even and how we handle null
 */
public class OddEvenLinkedList {
	 public ListNode oddEvenList(ListNode head) {
	        if(head == null) return head;
	        ListNode odd = head, even = head.next, evenHead = even;
	        
	        //we need to check even.next != null
	        //because is possible that when even.next = null
	        // odd.next= null; odd = odd.next; even.next = odd.next; throws NPE;
	        while(even != null && even.next != null){
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        
	        return head;
	    }
}
