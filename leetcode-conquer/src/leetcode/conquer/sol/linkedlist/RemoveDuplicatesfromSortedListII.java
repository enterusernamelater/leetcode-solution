package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * self wrote sol using a prev pointer to keep track of the previous node before dup
 * first remove all other dups after the first dup node, increment the cur to the first dup node's next- the non dup node 
 * and then point previous to the dup node's next
 * Time O(n) space O(1);
 */
public class RemoveDuplicatesfromSortedListII {
	
	public RemoveDuplicatesfromSortedListII(){}
	
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while(cur != null){
        	if(cur.next != null && cur.next.val == cur.val){

        		while(cur.next != null && cur.next.val == cur.val){
        			cur.next = cur.next.next;
        		}
        		cur = cur.next;
        		prev.next = cur;
        	}else{
        		prev = cur;
        		cur = cur.next;   
        	}
        }
        return dummy.next;
    }
}
