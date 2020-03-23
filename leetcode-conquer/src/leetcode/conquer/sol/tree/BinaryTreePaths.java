package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.conquer.tree.TreeNode;

/*
 * Binary Tree pre-order traverse until a leaf node hits while recording the string
 * Time O(n)
 * Space constant
 */
public class BinaryTreePaths {
	public BinaryTreePaths() {}
	
    List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        helper(root,String.valueOf(root.val));
        return res;
    }
    
    void helper(TreeNode root, String s){  
        if(root.left ==null && root.right == null) res.add(s);
        
        if(root.left != null)
        helper(root.left, s+"->"+root.left.val);
        
        if(root.right != null)
        helper(root.right,s+"->"+root.right.val);
    }
}
