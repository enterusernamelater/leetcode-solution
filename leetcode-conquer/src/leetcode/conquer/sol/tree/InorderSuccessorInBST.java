package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * a very simple solution, in order traverse + always looking for the min value
 * if the node val is greater than the p.val
 */
public class InorderSuccessorInBST {
    TreeNode res = null;
    
    public InorderSuccessorInBST() {}
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root,p);
        return res;
    }
    
    void helper(TreeNode root, TreeNode p){
        if(root == null) return;
        
        helper(root.left,p);
        
        if(root.val>p.val) 
            res = res == null? root : res.val > root.val? root : res;
        
        helper(root.right,p);
    }
}
