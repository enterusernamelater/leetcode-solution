package leetcode.conquer.sol.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.conquer.tree.TreeNode;

/*
 * This solution uses stack to track the preorder traverse.
 * we add left to the result and stack during pre-order traverse
 * if left has no right and left we reached to the end so we just pop
 * if a left has a right. the right is our new root.
 * and we add the right to the result first
 * then we move to the right node'left and the the logic repeats
 * Time O(n)
 * space O(n)
 * 
 * Pre-order: root,left, right
 * 
 * recursion solution included as well, easy af
 */
public class BinaryTreePreorderTraversal {
	public BinaryTreePreorderTraversal() {}

	private List<Integer> res = new ArrayList<>();
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) return res;
		Deque<TreeNode> stack = new ArrayDeque<>();
		//initialize stack
		stack.push(root);
		res.add(root.val);
		root = root.left;

		while(!stack.isEmpty()){
			while(root != null){
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}

			while(!stack.isEmpty() && stack.peek().right == null) stack.pop();

			if(!stack.isEmpty()){
				root = stack.pop().right;
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}
		}

		return res;
	}

	//recursion
	public void helper(TreeNode root){
		if(root == null) return;
		res.add(root.val);
		helper(root.left);
		helper(root.right);
	}
}
