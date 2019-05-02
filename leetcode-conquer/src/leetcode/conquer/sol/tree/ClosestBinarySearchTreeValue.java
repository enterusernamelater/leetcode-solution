package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * This is an easy question, using a preorder traverse and keep track the min diff 
 * using Math.abs. once the new min diff is find, update the result int
 * Time o(n), space o(h)
 */
public class ClosestBinarySearchTreeValue {
	public ClosestBinarySearchTreeValue() {}
	
    int res = 0;
    double diff = Double.MAX_VALUE;
    
    public int closestValue(TreeNode root, double target) {
        helper(root,target);
        return res;
    }
    
    void helper(TreeNode root, double target){
        if(root == null) return;
        if(diff > Math.abs(target-root.val)){
            res = root.val;
            diff = Math.abs(target-root.val);
        }
        helper(root.left, target);
        helper(root.right, target);
    }
}
