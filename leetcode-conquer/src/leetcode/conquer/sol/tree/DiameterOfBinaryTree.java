package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * post order traverse, keep a max on a node's longest path while pass along the longest length between left and right branch
 * to the parent node.
 * Time O(n)
 * Space constant
 */
public class DiameterOfBinaryTree {
	public DiameterOfBinaryTree() {}

	int res = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
		helper(root);
		return res;
	}

	private int helper(TreeNode root){
		if(root == null) return 0;

		int left = helper(root.left);
		int right = helper(root.right);
		res = Math.max(res,left+right);

		return Math.max(left,right)+1;
	}
}
