package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * in order traverse is how to sort bst. so once a root.val is greater than p found we return the root
 * Time O(n)
 * Space constant
 */
public class InorderSuccessorInBST {
    TreeNode res = null;
    
    public InorderSuccessorInBST() {}
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        
        TreeNode left = inorderSuccessor(root.left,p);
        if(left != null) return left;
        if(root.val > p.val) return root;
        TreeNode right = inorderSuccessor(root.right,p);
        if(right != null) return right;
        return null;
    }
}
