package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * Floyd's cycle-finding algorithm,
 * Time O(n) Space O(1)
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode runner = head;
        ListNode walker = head;
        while(runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            walker = walker.next;
            
            if(runner.val == walker.val) return true;
        }
        
        return false;
    }
}
