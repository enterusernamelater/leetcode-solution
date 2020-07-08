package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.tree.Node;

public class ReverseLinkedLIstCycle {
	public ReverseLinkedLIstCycle() {}
	
	   public Node reverseList(Node head) {
		   Node dummy = new Node(0);
	        dummy.next = head;
	        Node pre = dummy;
	        Node pointer = dummy.next;
	        
	        while(pointer != null && pointer.next != null && pointer.next != pointer){
		        Node save = pointer.next.next;
	            pointer.next.next = pre.next;
	            pre.next = pointer.next;
	            pointer.next = save;
	        }
	        
	        pointer.next = pre.next;
	        return dummy.next;
	    }
}
