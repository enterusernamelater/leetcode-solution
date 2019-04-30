package leetcode.conquer.sol.tree.bst;

import leetcode.conquer.tree.TreeNode;
/*
 * this question is a node rotation question. first find the left most node as the root and we rotate each node above clockwise
 * to fit the question. 
 * solution referring to: http://rainykat.blogspot.com/2017/01/leetcodelinkedin-156-binary-tree-upside.html
 * time o(n), space o(h)
 */
public class BinaryTreeUpsideDown {
	public BinaryTreeUpsideDown() {}
	
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}
