package leetcode.conquer.sol.tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.conquer.tree.TreeNode;

/*
 * a bfs approach that traverse a tree on each leveler using a queue
 * Time O(n)
 * Space O(n)
 */
public class MaximumLevelSumOfABinaryTree {
	public MaximumLevelSumOfABinaryTree() {}
	
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 0;
        int cur = 0;
        int res=0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            int sum = 0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum+=node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            
            if(sum>cur){
                cur = sum;
                res = level;
            }
        }
        return res;
    }
}
