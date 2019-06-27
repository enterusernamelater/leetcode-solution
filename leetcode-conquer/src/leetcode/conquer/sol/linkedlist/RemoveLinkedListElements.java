package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * use previous node to connect the remove node.next to skip the remove node and increment the cur node to its next position
 * Time O(n), Space O(1)
 */
public class RemoveLinkedListElements {
	public RemoveLinkedListElements() {}
	
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur=cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}
