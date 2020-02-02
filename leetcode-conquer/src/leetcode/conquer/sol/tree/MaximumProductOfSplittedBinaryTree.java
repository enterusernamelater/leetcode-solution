package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * first post order traverse tree first find the total sum
 * then traverse again but this time use the total sum found the first time
 *  minus the current sum and get the product while doing so keep track the max product result
 *  and return
 *  T: O(n)
 *  space O(n) due to recursion stack but on paper is constant
 */
public class MaximumProductOfSplittedBinaryTree {
	public MaximumProductOfSplittedBinaryTree() {}
	
	 private int mod =1000000000 + 7;
	    private long res = 0;
	    public int maxProduct(TreeNode root) {
	        if(root == null) return 0;
	        long total = helperTotal(root);
	        helper(total,root);
	        return (int)(res%mod);
	    }
	    
	    private long helper(long total, TreeNode root){
	        if(root == null) return 0;
	        
	        long val = root.val;
	        long left =  helper(total, root.left);
	        long right = helper(total, root.right);
	        long sum = val + left + right;
	        res = Math.max((total-sum)*sum, res);
	        return sum;
	    }
	    
	    private long helperTotal(TreeNode root){
	        if(root == null) return 0;
	        
	        long val = root.val;
	        long left =  helperTotal(root.left);
	        long right = helperTotal(root.right);

	        return val + left + right;
	    }
}
