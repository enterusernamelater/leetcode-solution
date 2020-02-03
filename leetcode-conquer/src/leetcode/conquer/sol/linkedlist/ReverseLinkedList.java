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
	
    public ListNode reverseListRecursiveSol(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode root = new ListNode(0);
        helper(head,root);
        return root.next;
    }
    
    private ListNode helper(ListNode head,ListNode root){
        if(head.next == null) {
            root.next = head;
            return head;
        }
        ListNode node = helper(head.next,root);
        node.next = head;
        head.next = null;
        return node = node.next;
    }
	
    public ListNode reverseListMySol(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode cur = head;
        ListNode prev = new ListNode(0);
        
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = tmp;
        }
        return prev.next;
    }
	
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
