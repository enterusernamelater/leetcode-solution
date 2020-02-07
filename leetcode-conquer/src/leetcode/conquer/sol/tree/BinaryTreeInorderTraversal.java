package leetcode.conquer.sol.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.conquer.tree.TreeNode;

/*
 *In order traverse: left,root,right
 *using a stack, when reach an end node with no left and right branch
 *we pop and add.
 *during stack pop if the node has a right node,
 *we then pop the current node from stack and add it to the result list as now
 *the root of the current tree is completed
 *now is time to traverse the new right branch so we make the right branch node as the new root
 *by push it to the stack, and initialize the start traverse point on it left.
 *
 *Time O(n)
 *Space O(n)
 */
public class BinaryTreeInorderTraversal {
	public BinaryTreeInorderTraversal() {}

	private List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null) return res;
		Deque<TreeNode> stack = new ArrayDeque<>();
		//initialize
		stack.push(root);
		root = root.left;
		while(!stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}

			while(!stack.isEmpty() && stack.peek().right == null){
				root = stack.pop();
				res.add(root.val);
			}

			if(!stack.isEmpty()){
				root = stack.pop();
				res.add(root.val);
				//new root to the stack
				root = root.right;
				stack.push(root);
				//Initialize the starting traverse point on the left, for the next while to kick in
				root = root.left;
			}
		}
		return res;
	}

	//recursion
	private void helper(TreeNode root){
		if(root == null) return;
		helper(root.left);
		res.add(root.val);
		helper(root.right);
	}
}
