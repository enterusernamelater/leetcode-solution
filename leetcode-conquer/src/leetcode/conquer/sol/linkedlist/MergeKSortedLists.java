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
        
        //this alg below only works the given lists are sorted otherwise no guarantee the first pop is the smallest
        while(!q.isEmpty()){
            ListNode curr = q.poll();
            tail.next = new ListNode(curr.val);
            tail = tail.next;
            
            if(curr.next != null) q.offer(curr.next);
        }
        return dummy.next;
    }
    
    //add everything into priorityQueue and pop them out. simple
    public ListNode mergeKListsSolTwo(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
            while(node != null){
                queue.offer(node);
                node = node.next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            curr.next = new ListNode(node.val);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
