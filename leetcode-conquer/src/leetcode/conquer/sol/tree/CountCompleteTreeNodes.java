package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * first find the h and then find all the nodes for the last h level.
 * or just do a preorder traverse with a count..either way I think this question is stupid
 * time o(n), space complexity I think will be the number of nodes in the last level.
 */
public class CountCompleteTreeNodes {
	public CountCompleteTreeNodes() {}

	int resH = 0;
	public int countNodes(TreeNode root) {
		if(root==null) return 0;
		int h = height(root);
		helper(root,1,h);
		return resH+((int)Math.pow(2,h-1))-1; 
	}

	void helper(TreeNode root,int level,int h){
		if(root == null) return;
		if(level == h) resH++;

		helper(root.left,level+1,h);
		helper(root.right,level+1,h);
	}

	int height(TreeNode node){
		if(node == null) return 0;
		return 1+Math.max(height(node.left),height(node.right));
	}

}
