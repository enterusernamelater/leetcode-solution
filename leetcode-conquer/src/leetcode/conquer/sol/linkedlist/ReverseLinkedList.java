package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * a super chill sol on reverse linklist we turn the node to its previous.
 * referring to leet code solution on this one.
 * 
 * Time O(N), Space O(1)
 */
public class ReverseLinkedList {
	public ReverseLinkedList() {}
	
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        return prev;
    }
}
