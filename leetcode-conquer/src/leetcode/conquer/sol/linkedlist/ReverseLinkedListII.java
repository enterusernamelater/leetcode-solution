package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * no point explain..a detailed sol link can be find in here:
 * https://www.youtube.com/watch?v=esl_A_pzBcg
 * Time O(N) Space O(1)
 */
public class ReverseLinkedListII {
	  public ReverseLinkedListII() {}
	  
	  public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head == null) return head;
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        
	        ListNode prev =dummy;
	        ListNode mNode=head;
	        ListNode nNode=head;
	        
	        for(int i=1;i<m;i++){
	            prev = mNode;
	            mNode = mNode.next;
	        }
	        
	        for(int i=1;i<n;i++){
	            nNode = nNode.next;
	        }
	        
	        while(mNode != nNode){
	            prev.next = mNode.next;
	            mNode.next = nNode.next;
	            nNode.next = mNode; 
	            mNode = prev.next;
	        }
	        return dummy.next;
	    }
}
