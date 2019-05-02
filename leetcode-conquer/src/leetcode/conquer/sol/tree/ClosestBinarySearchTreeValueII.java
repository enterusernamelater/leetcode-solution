package leetcode.conquer.sol.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.conquer.tree.TreeNode;
/*
 * inorder to find number of k notes thats closet to the target. we first push all node vals through a stack using inorder traversal
 * once the stack is established, when reduce the stack by comparing the first and last node val diff to the target.
 * if the first node val diff is greater than the last node val diff when pop the first if is not we pop the last until the K size is reached.
 * time o(n), space o(n)
 */
public class ClosestBinarySearchTreeValueII {
	public ClosestBinarySearchTreeValueII() {}
	
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        helper(root,stack);
        
        while(stack.size()>k){
            if(Math.abs(stack.peekFirst()-target)<Math.abs(stack.peekLast()-target))
                stack.pollLast();
            else
                stack.pollFirst();
        }
        
        return new ArrayList<>(stack);
    }
    
    void helper(TreeNode root, Deque<Integer> stack){
        if(root == null) return;
        
        helper(root.left, stack);
        stack.push(root.val);
        helper(root.right, stack);
    }
}
