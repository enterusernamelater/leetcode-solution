package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.conquer.tree.TreeNode;
/*
 *very similar solution to the build bst tree question and UniqueBinarySearchTrees
 *the trick to this question is once the start and end intervals as in the UniqueBinarySearchTrees question
 *reaches to the end how do we return the connected tree nodes back up in the recursion
 *to do so we use a list, and in each root we form root's left and right by for loop on the return left and right
 *list. this is basically a combination of results you can form by connecting left and right list on root
 *left and right cannot swap place as its enforced by the bst property
 *
 *Time o(2^n)
 *Space o(2^n)
 *
 */
public class UniqueBinarySearchTreesII {

	public UniqueBinarySearchTreesII() {}

	public List<TreeNode> generateTrees(int n) {
		if(n==0) return new ArrayList<>();
		return helper(1,n);
	}

	private List<TreeNode> helper(int l, int r){
		List<TreeNode> res = new ArrayList<>();
		if(l>r) res.add(null);
		for(int i=l;i<=r;i++){
			List<TreeNode> left = helper(l, i-1);
			List<TreeNode> right = helper(i+1, r);
			for(TreeNode rnode : right)
				for(TreeNode lnode : left){
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					res.add(root);
				}
		}

		return res;
	}
}
