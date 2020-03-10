package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * this solution is basically a bst property in order traverse from small to large while doing so returning
 * the  position of current node, if the position == k we found the node and return the value all the way up
 * in the recursion
 * Time O(n) most worst case
 * Space constant
 */
public class KthSmallestElementinaBST {
    
    public KthSmallestElementinaBST() {}
    
    private Integer res = null;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,k,0);
    }
    
    //the int curr here is for pass down the next position when reaching the right node. 
    private int helper(TreeNode root, int k, int curr){
        if(root == null) return curr;
        
        int val =  helper(root.left,k,curr) + 1;
        
        if(res != null) return res;
        else if(val == k) res = root.val;
        
        val = helper(root.right, k, val);
        
        return val;
    }
}
