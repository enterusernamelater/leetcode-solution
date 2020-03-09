package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * inverse binary tree all the way from bottom to top
 * Time O(n)
 * space constant
 */
public class InvertBinaryTree {
	public InvertBinaryTree() {}
	
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if(root == null) return null;
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        root.left = right;
        root.right = left;
        return root;
    }
}
