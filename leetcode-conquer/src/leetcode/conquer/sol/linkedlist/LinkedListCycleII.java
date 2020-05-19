package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * 
 * Floyd's cycle-finding algorithm,
 * Time O(n) Space O(1)
 * a detailed explanation vid can be find in here
 * https://www.youtube.com/watch?v=LUm2ABqAs1w
 */
 
public class LinkedListCycleII {
	
	public LinkedListCycleII() {}
	
	/*
	 * a o(n) solution with constant space. what we do is first find where walker and runner meet
	 * and then one pointer starts from the begining and another pointer starts from where they meet
	 * traverse one at a time, where they meet is the starting point of the cycle
	 * if no cycle found return null
	 */
    public ListNode detectCycleMySol(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode first = head;
        ListNode second = head;
        
        while(second!= null && second.next != null){
            first = first.next;
            second = second.next.next;
            
            if(first == second) break;
        }
        
        if(second != first) return null;
        
        ListNode start = head;
        
        while(start != second){
            start = start.next;
            second = second.next;
        }
        
        return second;
    }
    
	public ListNode detectCycle(ListNode head) {
		ListNode runner = head;
		ListNode walker = head;

		while(runner != null && runner.next != null){
			walker = walker.next;
			runner = runner.next.next;

			if(walker == runner){
				ListNode slow = head;
				while(slow != walker){
					slow = slow.next;
					walker = walker.next;
				}
				return walker;
			}
		}
		return null;
	}
}
