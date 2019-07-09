package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * the idea of my solution here is using mod to find the correct rotate number when the rotate number is greater than the length
 * then use while loop on each rotate we swap start and end node. the end node is found by using a while loop from start to find end
 * Time O(k*n) Space O(1)
 */
public class RotateListMySol {
	public RotateListMySol() {}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        int len = 0;
        ListNode lenNode = head;
        for(len = 0; lenNode != null; len++)
            lenNode = lenNode.next;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        if(k>len) k = k%len;

        while(k>0){
            ListNode endPrev = prev;
            ListNode end = prev;
            while(end.next != null){
                endPrev = end;
                end = end.next;
            }
            
            end.next = prev.next;
            prev.next = end;
            endPrev.next = null;
            k--;
        }
        return dummy.next;
    }
}
