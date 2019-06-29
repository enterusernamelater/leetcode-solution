package leetcode.conquer.sol.linkedlist;

import leetcode.conquer.list.ListNode;

/*
 * a self wrote recursion sol that starts with a pointer startNode and a pointer endNode
 * until endNode reaches to the end, then we recursively compare with the start and end node 
 * if equals then start node increments 
 * Time O(N) Space O(N)
 */
public class PalindromeLinkedListRecursionSol {
    private ListNode startNode;
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode endNode = head;
        this.startNode = head;
        
        return helper(endNode);
    }
    
    private boolean helper(ListNode endNode){        
        if(endNode.next == null){
            if(endNode.val != startNode.val) return false;
            startNode = startNode.next;
            return true;
        }
        
        if(!helper(endNode.next)) return false;
        if(endNode.val != startNode.val) return false;
        startNode = startNode.next;
        return true; 
    }
}
