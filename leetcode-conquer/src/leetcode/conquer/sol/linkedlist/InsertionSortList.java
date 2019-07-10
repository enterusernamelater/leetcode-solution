package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

//an insertion sort alg using a dummy node to build
//Time O(n^2) Space O(1)
public class InsertionSortList {
	public InsertionSortList() {}
	
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr = head, next = null; 
        ListNode dummy = new ListNode(0);
        
        while(curr != null){
            next = curr.next;
            
            ListNode l = dummy;
            while(l.next != null && l.next.val < curr.val){
                l = l.next;
            }
            
            curr.next = l.next;
            l.next = curr;
            curr = next;
        }
        
        return dummy.next;
    }
}
