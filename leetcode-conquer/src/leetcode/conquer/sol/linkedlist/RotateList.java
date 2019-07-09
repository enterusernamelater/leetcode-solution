package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * The basic idea is to link the tail of the list with the head, make it a cycle. Then count to the rotate point and cut it.
 * the rotation point is calcualted by using the formula here len-k%len
 * Time O(n) space constant
 */
public class RotateList {
	
	public RotateList() {}
	
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int len = 0;
        ListNode end = head;
        
        for(len = 1; end.next != null; len++){
            end = end.next;
        }
        
        end.next = head;

        k = k%len;

        for(int i=1;i<len-k;i++){
            head = head.next;
        }
        
        end = head.next;
        head.next = null;
        
        return end;
    }
}
