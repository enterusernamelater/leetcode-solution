package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * all the way down preorder finding the same on a leaf node two sol
 * one mine, one from leetcode
 * Time O(N)
 * Space constant
 */
public class PathSum {
	public PathSum() {}
	
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        helper(root,0,sum);
        return res;
    }
    
    private void helper(TreeNode root,int cur,int sum){
        if(res || root == null) return;
        if(root.left == null && root.right == null && root.val + cur == sum) res = true;
        helper(root.left,cur + root.val, sum);
        helper(root.right,cur + root.val, sum);
    }
    
    public boolean hasPathSumSolTwo(TreeNode root, int sum) {
        return helper(root,sum);
    }
    
    private boolean helper(TreeNode root,int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
        return helper(root.left,sum - root.val) || helper(root.right,sum - root.val);
    }
}
