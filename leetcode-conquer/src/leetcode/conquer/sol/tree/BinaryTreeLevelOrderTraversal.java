package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.conquer.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public BinaryTreeLevelOrderTraversal() {}
	
    List<List<Integer>> res = new ArrayList<>();
    /*
     * a bfs solution that traverse through a tree line by line
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                arr.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(arr);
        }

        return res;
    }
    
    //this is a pre-order solution that traverse the tree by keeping a level tag on each node 
    //and using the level tag to add each node's val to its level val's list.
    public List<List<Integer>> levelOrderPreorderSolution(TreeNode root) {
        helper(root,0);
        return res;
    }
    
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(res.size() == level){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right, level+1);
    }
}
