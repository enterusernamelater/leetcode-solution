package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode.conquer.tree.TreeNode;

/*
 * this is a level order travseral solution using Queue.
 * the logic is the same as the prevous solution we use a min and max value to keep track the col width
 * then add the node to each cal width val list. at the end we consolidate all result into a list and return the list
 * the time is o(n) because we loop through all nodes once, each node gets add to the queue. space o(n) the map, the two queues..this is obvious
 */
public class BinaryTreeVerticalOrderTraversalSolTwo {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        q.add(root);
        col.add(0);
        
        int min = 0;
        int max = 0;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int colValue = col.poll();
            
            List<Integer> arr = map.getOrDefault(colValue,new ArrayList<Integer>());
            arr.add(node.val);
            map.putIfAbsent(colValue,arr);
            
            if(node.left != null){
                q.add(node.left);
                col.add(colValue-1);
                min = Math.min(colValue-1,min);
            }
            
            if(node.right != null){
                q.add(node.right);
                col.add(colValue+1);
                max = Math.max(colValue+1,max);
            }
            
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i= min; i<=max; i++)
            res.add(map.get(i));
            
        return res;
    }
}
