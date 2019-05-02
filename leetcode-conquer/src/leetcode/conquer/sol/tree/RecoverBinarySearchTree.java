package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;
/*
 * this solution was taken from: https://blog.csdn.net/Jin_Kwok/article/details/51159546
 * the idea is we know that a inorder of the binary tree gives out sorted ascending number;
 * and in this question, it has stated that only 1 pair of nodes are swapped. there fore only two cases 
 * can happend, 1. 321 this case we swap 3 and 1, another case is 13245, in this case we swap 2 and 3
 * the logic is keep track the previous val using inorder traverse, if the previous value is greater than the root value 
 * then we record that value and the one next to it, it is possible we encounter case 1, therefore we continue our traverse
 * while keeping the first found record. the traverse stops at another find where the previouse is greater than the root.val
 * the m2 now is recorded. in case 1, the m2 is the smallest amount the finding of comparing the previous value to the root val.
 * time o(n), space o(h)
 */
public class RecoverBinarySearchTree {
	public RecoverBinarySearchTree() {}

	TreeNode m1 = null;
	TreeNode m2 = null;
	TreeNode pre = null;

	public void recoverTree(TreeNode root) {
		helper(root);

		//swap
		int tmp = m1.val;
		m1.val = m2.val;
		m2.val = tmp;
	}

	void helper(TreeNode root){
		if(root == null) return;

		helper(root.left);
		if(pre != null && pre.val > root.val){
			if(m1 == null) m1 = pre;
			m2 = root;
		}
		pre = root;

		helper(root.right);
	}
}
