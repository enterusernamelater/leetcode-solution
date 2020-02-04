package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

//referring to solution: https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
public class ValidateBinarySearchTree {

	public ValidateBinarySearchTree() {}
	
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    boolean helper(TreeNode root, Long min, Long max){
        if(root == null) return true;
        
        if(root.val>=max || root.val<=min) return false;
        
        return helper(root.left,min,Long.valueOf(root.val)) && helper(root.right,Long.valueOf(root.val),max);
    }
}
