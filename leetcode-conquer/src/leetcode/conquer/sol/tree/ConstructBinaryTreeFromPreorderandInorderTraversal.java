package leetcode.conquer.sol.tree;

import java.util.HashMap;
import java.util.Map;

import leetcode.conquer.tree.TreeNode;
/*
 * This solution referring to: https://www.youtube.com/watch?v=S1wNG5hx-30
 * The idea is using the preorder arr to find the root, which is always the first index
 * then using binary search method to divide and conquer the inorder arr and set the
 * left and right. once divided, the first element of the preorder is again the root. so when use this root index
 * divide and conquer again, until we reach the end. 
 * using the hashmap upfront to get the inorder index so later can be used to use the root val to get the inorder arr index
 * Time O(n), Space O(n);
 */
public class ConstructBinaryTreeFromPreorderandInorderTraversal {
	public ConstructBinaryTreeFromPreorderandInorderTraversal() {}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i =0; i<inorder.length; i++){
			map.put(inorder[i],i);     
		}
		return helper(preorder, inorder, 0,0,inorder.length-1,map);
	}

	TreeNode helper(int[] preorder,int[] inorder,int prestart,int instart, int inend, Map<Integer,Integer> map){
		if(prestart > preorder.length || instart>inend) return null;
		TreeNode root = new TreeNode(preorder[prestart]);

		int i = map.get(preorder[prestart]);

		root.left = helper(preorder,inorder,prestart+1,instart,i-1,map);
		root.right= helper(preorder,inorder,prestart+(i-instart)+1,i+1,inend,map);

		return root;
	}
}
