package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * preorder traverse from left and right then checks to see if vals are equal
 * time complexity o(n) space o(n)
 */
public class SymmetricTree {
	  
	  public SymmetricTree() {}
	
	  public boolean isSymmetric(TreeNode root) {
	        return helper(root,root);
	    }
	    
	    private boolean helper(TreeNode t1, TreeNode t2){
	        if(t1 == null && t2 == null) return true;
	        if(t1 == null || t2 == null) return false;
	        
	        return (t1.val == t2.val) && helper(t1.left,t2.right) && helper(t1.right,t2.left);
	    }
}
