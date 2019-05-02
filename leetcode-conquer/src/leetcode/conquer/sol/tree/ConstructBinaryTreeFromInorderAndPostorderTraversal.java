package leetcode.conquer.sol.tree;

import java.util.HashMap;
import java.util.Map;

import leetcode.conquer.tree.TreeNode;

/*
 * This solution is pretty much the same to the ConstructBinaryTreeFromPreorderandInorderTraversal solution only
 * difference is that postorder has its root at last index;
 * The idea is using the postorder arr to find the root, which is always the last index
 * then using binary search method to divide and conquer the inorder arr and set the
 * left and right. once divided, the last element of the postorder is again the root. so when use this root index
 * divide and conquer again, until we reach the end. 
 * using the hashmap upfront to get the inorder index so later can be used to use the root val to get the inorder arr index
 * Time O(n), Space O(n);
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public ConstructBinaryTreeFromInorderAndPostorderTraversal() {}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) return null;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i =0; i<inorder.length; i++){
			map.put(inorder[i],i);     
		}
		return helper(postorder, inorder, postorder.length-1,0,inorder.length-1,map);
	}

	TreeNode helper(int[] postorder,int[] inorder,int posend,int instart, int inend, Map<Integer,Integer> map){
		if(posend < 0 || instart>inend) return null;
		TreeNode root = new TreeNode(postorder[posend]);

		int i = map.get(postorder[posend]);

		root.left= helper(postorder,inorder,posend-(inend-i)-1,instart,i-1,map);
		root.right = helper(postorder,inorder,posend-1,i+1,inend,map);

		return root;
	}
}
