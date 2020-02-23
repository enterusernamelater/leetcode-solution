package leetcode.conquer.sol.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.conquer.list.ListNode;

/*
 * we first reverse the second half of the linked list
 * then we reorder by connecting the each pair of first and second half node
 * where the 2ndHalfNode.next = 1halfNode.next
 * and 1halfNode.next= 2ndHalfNode.
 * once the connection is established when then cuts off the middle 'slower' to point its next to the 
 * tmp node we stored: ListNode tmp = cur.next; the cur is the current 2ndhalfNode that we just established 
 * the connection to the first half list
 * Time O(N) Space O(1)
 */
public class ReorderList {
	public ReorderList() {}
	
	/*
	 * I used a stack :shrug 
	 * reverse and then pop connect until we reach the mid
	 * Time o(N)
	 * Space O(n)
	 */
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode first = head;
        while(first != null){
            stack.push(first);
            first = first.next;
        }
        
        first = head;
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            
            //in odd case we reach the mid when first is equal to the next pop
            //in even case the first.next == q.peek();
            if(first == node || first.next == node){
                node.next = null;
                break;
            }
            node.next = first.next;
            first.next = node;
            first = node.next;
        }
    }
    
    public void reorderListSolTwo(ListNode head) {
        if(head == null) return;
        ListNode first = head;
        ListNode second = head;
        
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        
        ListNode mid = first;
        //reverse after mid
        ListNode pre = new ListNode(0);
        first = first.next;
      
        while(first != null){
            ListNode save = first.next;
            first.next = pre.next;
            pre.next = first;
            first = save;
        }
        
        second = pre.next;
        first = head;
        //now merge
        while(second != null){
            ListNode save = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = save;
        }
        //finally cuts off the mid
         mid.next = null;
    }
}
