package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * basically making the val a pwd. so once the pwd is meet we have a cycle
 * Time O(n) Space O(1)
 */
public class LinkedListCycleMySol {
	public LinkedListCycleMySol() {}
	
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        if(head == null) return false;
	        ListNode cur = head;
	        while(cur!= null){
	            if(cur.val == 85523049) return true;
	            cur.val = 85523049;
	            cur = cur.next;            
	        }
	        return false;
	    }
	}
}
