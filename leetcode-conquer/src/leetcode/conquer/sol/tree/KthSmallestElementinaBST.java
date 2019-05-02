package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * the Kth smallest element is the kth smallest number you can find in the BST from bottom to top
 * in a sorted way
 * this concept is similar to the kth smallest number in an array, if the array is sorted the kth smallest element
 * is the Array[k-1]
 * the approache to this question is a simple in order traverse with a count decrement, when we have count equals to 0
 * we return the result as the final result due to the BST property where the left node is smaller than the root and the right
 * node is greater than the root, this property is consistent throughout all subtrees in the BST.
 */
public class KthSmallestElementinaBST {
	
    int count = 0;
    int res = Integer.MAX_VALUE;
    
    public KthSmallestElementinaBST() {}
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    
    void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        count--;
        if(count == 0){
            res = root.val;
            return;
        }
        helper(root.right);
    }

}
