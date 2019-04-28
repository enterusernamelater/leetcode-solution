package leetcode.conquer.sol.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.conquer.tree.TreeNode;
/*
 * This solution uses the queue approach along with the inorder traverse.
 * store everything vals to the queue by using the inorder traverse which results a 
 * integer ascending order, because of the property of the BST.
 * once stored then when iterate the numbers in the queue to find the smallest by pop the first one
 * NOTE: stack-> last in first out, QUEUE -> first in first out.
 * Time complexity O(N) for store the values in the queue O(1) for access. 
 * Space complexity will be O(N)
 */
public class BinarySearchTreeIterator {
	public BinarySearchTreeIterator() {}
	
	Queue<Integer> queue = new LinkedList<>();
    public BinarySearchTreeIterator(TreeNode root) {
        helper(root);
    }
    
    void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.left);
        queue.add(root.val);
        helper(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
    
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
