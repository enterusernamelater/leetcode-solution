package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
	public LowestCommonAncestorOfABinaryTree() {}

	private boolean found = false;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return helper(root, p, q);
	}

	/*
	 * post order traverse pass a found p or q all the way down from the bottom and the check if the root is one of the p or q
	 * or both left and right is found to be p or q
	 * if root is p or q and one of left and right is p or q we return root.
	 * if left and right are p or q we return root.
	 * using a boolean to stop recursion and return the result.
	 * Time O(n)
	 * Space O(n)
	 */
	private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;

		TreeNode left = helper(root.left,p,q);
		if(found) return left;
		TreeNode right = helper(root.right,p,q);
		if(found) return right;

		if(root == p || root == q){
			if(left != null || right != null){
				found = true;
			}
			return root;
		}

		if(left != null && right != null){
			found = true;
			return root;
		}
		else if(left != null) return left;
		else if(right != null) return right;
		else return null;
	}
	
	/*
	 * a more easy recursion would be a preorder traverse, once one node is found on left or right.
	 * if the otherside (opposite to found node's side) returns null we know for sure the another p or q is a 
	 * child of the found node so we just return the found node.
	 * if both left and right are found as p or q we return root just as the above solution
	 * Time O(n)
	 * Space constant
	 */
    private TreeNode helperSolTwo(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        
        TreeNode left = helper(root.left,p,q);
        TreeNode right = helper(root.right,p,q);
        
        if(left != null && right != null) return root;
        else if(left != null) return left;
        else if(right != null) return right;
        else return null;
    }
}
