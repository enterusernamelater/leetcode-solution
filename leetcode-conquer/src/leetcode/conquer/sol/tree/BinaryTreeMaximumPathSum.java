package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * post order traverse, each time returning to root, calculate the max res, 
 * its either the left branch of root, right branch of right, the total of left,right branch values and root value or root value itself.
 * when return we return the max on the root, either root value it self or root's right branch value or root's left branch value
 * so the next max path can be calculated on the next root
 * 
 * Time O(n)
 * Space constant with recursion stack
 * 
 */
public class BinaryTreeMaximumPathSum {
	public BinaryTreeMaximumPathSum() {}

	private int res = 0;
	public int maxPathSum(TreeNode root) {
		helper(root);
		return res;
	}

	private int helper(TreeNode root){
		if(root == null) return 0;

		int left = helper(root.left);
		int right = helper(root.right);

		int val1 = root.val + left + right;
		int val2 = root.val + left;
		int val3 = root.val + right;
		int val4 = root.val;

		res = Math.max(val1,Math.max(val2,Math.max(val3,Math.max(val4,res))));

		return Math.max(val4,Math.max(val3,val2));
	}
}
