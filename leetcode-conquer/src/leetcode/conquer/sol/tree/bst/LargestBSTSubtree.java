package leetcode.conquer.sol.tree.bst;

import leetcode.conquer.tree.TreeNode;
/*
 * This is a understanding BST property question, when we use post order traverse we always
 * keep track of the left and right subtree's(starting from a single node) min and max value. because based on the BST property
 * a root has to be greater than the max of the left subtree and smaller than the min of right subtree.
 * if the above condition matches we increment the res value by left.res+right.res+1, if not match, we reset min max value by 
 * false the root.val>left.max && root.val<right.min condition and keep the res value
 * until we find the bigger res value.
 * Time O(n), Space O(n) or you can see its o(h) in which the worst case is o(n) because a tree can be just a straight line 
 * therefore there will be no stack pop in the memory for the method return.
 */
public class LargestBSTSubtree {

	public LargestBSTSubtree() {}

	public int largestBSTSubtree(TreeNode root) {
		Wrapper w = helper(root);
		return w.res;
	}

	Wrapper helper(TreeNode root){
		if(root == null){
			return new Wrapper(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		Wrapper left = helper(root.left);
		Wrapper right = helper(root.right);

		if(root.val>left.max && root.val<right.min)
			return new Wrapper(Math.min(root.val,left.min), Math.max(root.val,right.max),left.res+right.res+1);
		else
			return new Wrapper(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.res,right.res));
	}

	class Wrapper{
		public int min;
		public int max;
		public int res;
		public Wrapper(int min, int max, int res){
			this.min = min;
			this.max = max;
			this.res = res;
		}
	}

}
