package leetcode.conquer.sol.recursion;

import leetcode.conquer.list.ListNode;

/*
 * recursive way of doing this problem link:
 * https://www.youtube.com/watch?v=DryIN7iL4pA
 * Time O(n) Space O(1)
 */
public class ReverseNodesInKGroupRecursiveSol {
	
	public ReverseNodesInKGroupRecursiveSol() {}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        int count=0;
        ListNode cur = head;
        while(cur!=null && count != k){
            cur = cur.next;
            count++;
        }
        
        if(count == k){
            cur = reverseKGroup(cur,k);      
            //after the last recursion the cur will be the end of the reverse group
            //head points to the first node to swap
            //we point head.next to the end which is the cur node, and making head as the end node 'cur'
            //then making tmp to be the next node to swap -> the head
            //and when next loop comes, the tmp node is the new head and will be pointing to the 
            //new end cur node and the tmp nodes next is the new head ready for the next loop's swap.
            while(count > 0){
                ListNode tmp = head.next;
                head.next =cur;
                cur = head;
                head = tmp;
                count--;
            }
            head = cur;
        }
        
        return head;
    }
}
