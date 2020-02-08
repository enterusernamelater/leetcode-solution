package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * search for the node that has no left and right leaf record the min level took along the way
 * if root is null we just return because we know the root node from recursion is not a leaf node
 * A leaf is a node with no children.
 * Time O(N)
 * Space constant with recursion stack
 */
public class MinimumDepthOfBinaryTree {
	public MinimumDepthOfBinaryTree() {}
	
    private int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root,1);
        return res;
    }
    
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(root.left == null && root.right == null){
            res = Math.min(level,res);
            return;
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}
