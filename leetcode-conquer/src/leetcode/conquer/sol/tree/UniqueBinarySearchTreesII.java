package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.conquer.tree.TreeNode;
/*
 * This solution is referring to youtube vid https://www.youtube.com/watch?v=GZ0qvkTAjmw
 * a super hard question..my weakness right is the recursive approach involves loop. 
 * this solution takes divide and conquer approche by following the sol from question 96
 * for 1.k..n , the root k's left side will have only 1 to k-1 nodes and the right side will
 * have k+1 to n node. we keep divide and conquer for each  1..k-1 and k+1..n and add them up from 
 * bottom to top until we reach the top loop index and adding the index root to the res arr, the root already has
 * all its subtrees connected from the recursive helper. then the loop moves to the next index i+1 from 1....i...n
 * and this divide and conquer process repeats
 * I think the time complexity is o(n^3) and space complexity is o(n) but not sure..
 */
public class UniqueBinarySearchTreesII {
	
	public UniqueBinarySearchTreesII() {}
	
	public List<TreeNode> generateTrees(int n) {
		return helper(1,n);
	}

	List<TreeNode> helper(int min, int max){
		if(min>max) return new ArrayList<>();
		List<TreeNode> res = new ArrayList<>();

		for(int i = min; i<=max;i++){
			List<TreeNode> leftNodes = helper(min,i-1);
			List<TreeNode> rightNodes = helper(i+1,max);

			if(leftNodes.isEmpty() && rightNodes.isEmpty()){
				TreeNode root = new TreeNode(i);
				res.add(root);
			}else if(rightNodes.isEmpty()){
				for(TreeNode node : leftNodes){
					TreeNode root = new TreeNode(i);
					root.left = node;
					res.add(root);
				}
			}else if(leftNodes.isEmpty()){
				for(TreeNode node : rightNodes){
					TreeNode root = new TreeNode(i);
					root.right = node;
					res.add(root);
				}
			}else{
				for(TreeNode leftNode : leftNodes)
					for(TreeNode rightNode : rightNodes){
						TreeNode root = new TreeNode(i);
						root.left=leftNode;
						root.right = rightNode;
						res.add(root);
				}
			}
		}

		return res;
	}
}
