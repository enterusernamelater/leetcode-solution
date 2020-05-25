package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.conquer.tree.TreeNode;

/*
 * use bfs and store the last one.
 * Time O(n)
 * Space constant
 */
public class BinaryTreeRightSideView {
	public BinaryTreeRightSideView() {}
	
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i == size-1){
                    res.add(curr.val);
                }
                
                if(curr.left != null){
                    q.offer(curr.left);
                }
                
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
        }
        
        return res;
    }
    
    
    //dfs pre order on right only add the first right to map if level not found
    public List<Integer> rightSideViewDFS(TreeNode root) {
        if(root == null) return new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        dfs(map,root,1);
        return new ArrayList<>(map.values());
    }
    
    public void dfs(HashMap<Integer,Integer> map, TreeNode root, int level){
            if(root == null) return;
            if(!map.containsKey(level)) map.put(level,root.val);
        
            dfs(map,root.right,level+1);
            dfs(map,root.left,level+1);
    }
}
