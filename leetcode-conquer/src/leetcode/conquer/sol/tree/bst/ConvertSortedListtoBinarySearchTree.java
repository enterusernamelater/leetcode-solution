package leetcode.conquer.sol.tree.bst;

import leetcode.conquer.list.ListNode;
import leetcode.conquer.tree.TreeNode;

/*
 * This solution uses slow fast pointer to find the mid val 
 * once mid value is found, we construct the BST through binary search
 * Time complexity O(n), space complexity O(h); 
 */
public class ConvertSortedListtoBinarySearchTree {
	
	public ConvertSortedListtoBinarySearchTree() {}
	
	public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }
    
    TreeNode helper(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        ListNode mid = findMid(head);
        
        TreeNode node = new TreeNode(mid.val);
        
        node.left = helper(head);
        node.right = helper(mid.next);
        return node;
    }
    
    ListNode findMid(ListNode head){
        if(head == null) return null;
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            pre=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
}
