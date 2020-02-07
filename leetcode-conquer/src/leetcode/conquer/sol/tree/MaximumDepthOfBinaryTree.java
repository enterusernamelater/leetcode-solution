package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * pre-order solution, max on the level
 * Time O(n)
 * Space O(n)
 */
public class MaximumDepthOfBinaryTree {
	public MaximumDepthOfBinaryTree() {}
	
    private int res = 0;
    public int maxDepth(TreeNode root) {
        helper(root,1);
        return res;
    }
    
    private void helper(TreeNode root,int level){
        if(root == null) return;
        res = Math.max(res,level);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}
