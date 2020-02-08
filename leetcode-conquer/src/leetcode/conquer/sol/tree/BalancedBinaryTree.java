package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * bottom up find difference on each node and return node's max level for the next 
 * difference calculation
 * stops recursion if not-balanced found;
 * Time O(n)
 * Space constant but with recursion stack
 */
public class BalancedBinaryTree {
	private boolean notBalanced = false;
	
	public boolean isBalanced(TreeNode root) {
		helper(root,0);
		return !notBalanced;
	}

	private int helper(TreeNode root, int level){
		if(root == null) return level;
		if(notBalanced) return 0;

		int levell = helper(root.left,level+1);
		int levelr = helper(root.right,level+1);
		if(Math.abs(levell-levelr) > 1) notBalanced = true;
		return Math.max(levell,levelr);
	}
}
