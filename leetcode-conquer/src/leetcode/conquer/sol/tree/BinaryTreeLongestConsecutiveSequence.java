package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * pre order solution traversing the tree and keep res up to date with consecutive numbers
 * if a break on the consecutive detacted reset cur to 1
 * 
 * Time O(n)
 * Space constant
 */
public class BinaryTreeLongestConsecutiveSequence {
	public BinaryTreeLongestConsecutiveSequence() {}
	
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root,1);
        return res;
    }
    
    private void helper(TreeNode root, int cur){
        res = Math.max(cur,res);
        if(root.left != null){
            helper(root.left, root.left.val - root.val == 1? cur+1 : 1);
        }
        
        if(root.right != null){
            helper(root.right, root.right.val - root.val == 1? cur+1 : 1);
        }
    }
}
