package leetcode.conquer.sol.linkedlist;

import java.util.PriorityQueue;

import leetcode.conquer.list.ListNode;

/*
 * use priority queue to sort the lists..
 * pretty self explanatory code
 * Time O(nlog(n)) space O(n)
 */
public class MergeKSortedLists {
	public MergeKSortedLists() {}
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(int i=0;i<lists.length;i++) 
            if(lists[i] != null)
                q.offer(lists[i]);
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(!q.isEmpty()){
            ListNode curr = q.poll();
            tail.next = new ListNode(curr.val);
            tail = tail.next;
            
            if(curr.next != null) q.offer(curr.next);
        }
        return dummy.next;
    }
}
