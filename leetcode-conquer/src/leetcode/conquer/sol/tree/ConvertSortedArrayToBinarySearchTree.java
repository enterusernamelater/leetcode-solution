package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * use binary search find each mid as the root and construct left and right side
 * of the binary tree 
 * from bottom to top
 * Time O(n)
 * Space constant
 */
public class ConvertSortedArrayToBinarySearchTree {
	public ConvertSortedArrayToBinarySearchTree() {}
	
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;        
        return helper(nums,0,nums.length-1);
    }
    
    private TreeNode helper(int[] nums,int l, int r){
        if(l>r) return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,l,mid-1);
        root.right = helper(nums,mid+1,r);
        
        return root;
    }
}
