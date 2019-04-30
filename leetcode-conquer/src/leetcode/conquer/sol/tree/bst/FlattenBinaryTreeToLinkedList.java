package leetcode.conquer.sol.tree.bst;

import leetcode.conquer.tree.TreeNode;

/*
 * post order traverse to the right, keep track of a pre val.
 * traverse from bottom up, each time, attach the node's right branch to the previous 
 * and disconnect the left node (making the left null)
 * time o(n), space o(n)
 */
public class FlattenBinaryTreeToLinkedList {
	public FlattenBinaryTreeToLinkedList() {}
		
    TreeNode pre = null;
    
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.right);
        helper(root.left);
        
        root.right = pre;
        root.left = null;
        pre = root;
    }	
}
