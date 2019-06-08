package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * time o(n) space constant, o(1)
 * please referring to the leetcode solution for detailed explanation. 
 */
public class RemoveDuplicatesfromSortedList {
	public RemoveDuplicatesfromSortedList() {}
	
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = head;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return root;
    }
}
