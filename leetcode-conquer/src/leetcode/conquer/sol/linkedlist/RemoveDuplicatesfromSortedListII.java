package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;


public class RemoveDuplicatesfromSortedListII {
	
	public RemoveDuplicatesfromSortedListII(){}
	
	/*
	 * its pretty much the same soltuion as the first one
	 * the only difference is after a same pair found I pull the next.next
	 * at the same time checking if the pulled pair is the same as the head
	 * if is not then I move head to the next because we cant link any duplication
	 * in the result list, in the next loop the head will be added to the result list
	 * and gets incremented
	 * Time O(n) 
	 * Space O(n)
	 * 
	 */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode root = new ListNode(0);
        ListNode p1 = root;
        while(head != null){
            if(head.next!=null && head.val == head.next.val){
                head.next=head.next.next;
                //head.next == null for speical cases like 1,1,1,1 
                if(head.next == null || head.val != head.next.val){
                    head = head.next;
                }
            }else{
                p1.next = new ListNode(head.val);
                p1 = p1.next;
                head = head.next;
            }
        }
        
        return root.next;
    }
	
    /*
     * self wrote sol using a prev pointer to keep track of the previous node before dup
     * first remove all other dups after the first dup node, increment the cur to the first dup node's next- the non dup node 
     * and then point previous to the dup node's next
     * Time O(n) space O(1);
     */
    public ListNode deleteDuplicatesSolTwo(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while(cur != null){
        	if(cur.next != null && cur.next.val == cur.val){

        		while(cur.next != null && cur.next.val == cur.val){
        			cur.next = cur.next.next;
        		}
        		cur = cur.next;
        		prev.next = cur;
        	}else{
        		prev = cur;
        		cur = cur.next;   
        	}
        }
        return dummy.next;
    }
}
