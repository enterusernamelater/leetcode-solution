package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * follow the bst property when both p,q is less than root.val we know p q belong to root's left side
 * so we traverse to root.left, when both p,q is bigger than root.val we know p q belong to root's right side
 * if both p and q are on either side of the root we know we have found the answer so we return the root.
 * Time O(n)
 * Space constant
 */
public class LowestCommonAncestorOfABinarySearchTree {
	public LowestCommonAncestorOfABinarySearchTree() {}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == p || root == q) return root;

		if(root.val < p.val && root.val < q.val){
			return lowestCommonAncestor(root.right,p,q);
		}else if(root.val > p.val && root.val > q.val){
			return lowestCommonAncestor(root.left,p,q);
		}else{
			return root;
		}
	}
}
