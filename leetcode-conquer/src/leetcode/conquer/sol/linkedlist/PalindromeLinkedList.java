package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * this solution first reverse the second half and then
 * we start to compare the first half and second half linkedlist
 * if they are the same then we return true otherwise false;
 * Time O(N) Space O(1)
 */
public class PalindromeLinkedList {
	
	public PalindromeLinkedList() {}
	
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the second half
        ListNode cur = slow.next;
        ListNode prev = null;
        
        while(cur != null){  
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        slow.next = prev;
        
        //starting comparing from start and mid start
        cur = head;
        ListNode end = slow.next;
        
        while(end != null){
            if(cur.val != end.val) return false;
            cur = cur.next;
            end = end.next;
        }
        
        return true;
    }
}
