package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.conquer.tree.TreeNode;

/*
 * a very similar solution to its previous question Path Sum,
 * we difference sum and current sum reaches 0 we add the list to the result
 * and when a pre-order completed, we need to remove the added nodes to from the list
 * 
 * Time O(n)
 * Space constant
 */
public class PathSumII {
	public PathSumII() {}

	private List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		helper(root,sum, new ArrayList<>());
		return res;
	}

	private void helper(TreeNode root, int sum, List<Integer> list){
		if(root == null) return;

		list.add(root.val);
		if(root.left == null && root.right == null && sum - root.val == 0){
			res.add(new ArrayList<>(list));
		}

		helper(root.left,sum-root.val,list);
		helper(root.right,sum-root.val,list);
		list.remove(list.size()-1);
	}
}
