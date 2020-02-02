package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import leetcode.conquer.tree.TreeNode;
/*
 * this sol is referring to the Print a Binary Tree in Vertical Order | Set 1
 * Link: https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * find the min and max horizontal distance once thats done, for loop from min to max
 * use a treemap to sort the level and add val to treeMap when the current distance in the same as the 
 * distance from min to max (the index of the loop). once the loop end we consolidate the treemap val list into one list
 * and them add the list to the res. 
 * time O(n^2), SPACE O(N)
 */
public class BinaryTreeVerticalOrderTraversal {
	public BinaryTreeVerticalOrderTraversal() {}
	
    List<List<Integer>> res = new ArrayList<>();
    TreeMap<Integer,List<Integer>> treeMap = new TreeMap<>((a,b) -> a-b);
    int max =0;
    int min = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return res;
        findMaxMinDistance(root,0);
        for(int i = min; i<=max;i++){
            helper(root,i,0,0);
            List<Integer> tmp = new ArrayList<>();
            for(List<Integer> arr : treeMap.values()){
                for(int value : arr)
                    tmp.add(value);
            }
            treeMap.clear();
            res.add(tmp);
        }
        
        return res;
    }
    
     void findMaxMinDistance(TreeNode root, int hd){
        if(root == null) return;
        
        if(hd<min) min = hd;
        if(hd>max) max = hd;
        
        findMaxMinDistance(root.left, hd-1);
        findMaxMinDistance(root.right, hd+1);
    }
    
    void helper(TreeNode root, int cur, int hd, int level){
        if(root == null) return;
        
        if(hd == cur) {
            List<Integer> arr = treeMap.getOrDefault(level, new ArrayList<>());
            arr.add(root.val);
            treeMap.putIfAbsent(level,arr);
        }

        helper(root.left, cur, hd-1,level+1);
        helper(root.right, cur, hd + 1,level+1);
    }
}
