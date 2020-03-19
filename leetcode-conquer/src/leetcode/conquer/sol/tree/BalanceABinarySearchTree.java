package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.conquer.tree.TreeNode;

/*
 * first inorder traverse finding the sorted sequence of the given bst
 * then divide from the sorted list's mid and build the balanced bst
 * Time O(n)
 * Space O(n)
 */
public class BalanceABinarySearchTree {
	public BalanceABinarySearchTree() {}
	
	 public TreeNode balanceBST(TreeNode root) {
	        if(root == null) return root;
	        List<TreeNode> list = new ArrayList<>();
	        inorderlist(root,list);
	        return buildTree(list,0, list.size()-1);
	    }
	    
	    private TreeNode buildTree(List<TreeNode> list, int l, int r){
	        if(l>r) return null;
	        int mid = l + (r-l)/2;
	        TreeNode node = list.get(mid);
	        node.left = buildTree(list,l,mid-1);
	        node.right = buildTree(list,mid+1,r);
	        return node;
	    }
	    
	    private void inorderlist(TreeNode root, List<TreeNode> list){
	        if(root == null) return;
	        
	        inorderlist(root.left,list);
	        list.add(root);
	        inorderlist(root.right,list);
	    }
}
