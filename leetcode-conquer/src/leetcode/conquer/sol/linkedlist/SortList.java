package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * merge sort on linkedlist see link below for detailed explanation:
 * https://www.youtube.com/watch?v=pNTc1bM1z-4
 * Time O(nlog(n)) Space O(1)
 */
public class SortList {
	public SortList() {}
	
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode leftStart = head;
        ListNode leftEnd = head;
        ListNode rightStart = head;
        ListNode rightEnd = head;
        
        while(rightEnd != null && rightEnd.next != null){
            leftEnd = rightStart;
            rightStart = rightStart.next;
            rightEnd = rightEnd.next.next;
        }
        
        leftEnd.next = null;
        
        ListNode left = sortList(leftStart);
        ListNode right = sortList(rightStart);
        
        return merge(left,right);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(left != null && right !=null){
            if(left.val < right.val){
                curr.next = left;
                curr = curr.next;
                left = left.next;
            }else{
                curr.next = right;
                curr = curr.next;
                right = right.next;
            }
        }
        
        if(left != null){
            curr.next = left;
        }
        
        if(right != null){
            curr.next = right;
        }
        
        return dummy.next;
    }
}
