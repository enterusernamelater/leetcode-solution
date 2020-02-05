package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.conquer.tree.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	public BinaryTreeLevelOrderTraversalII() {}
	
    private List<List<Integer>> res = new ArrayList<>();
    
    /*
     * same as the previous BinaryTreeLevelOrderTraversal sol in the end I just reverse the list
     * Time O(n) because reverse is O(n)
     */
    public List<List<Integer>> levelOrderBottomSolTwo(TreeNode root) {
    	helperSolTwo(root,0);
        Collections.reverse(res);
        return res;
    }
    
    private void helperSolTwo(TreeNode root, int level){
        if(root == null) return;
        if(res.size() == level){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right, level+1);
    }
    
    /*
     * this solution always adds a new list to the first index of the array
     * and in the end we use the res size minus the level to reverse the order in the array
     * so if is the last level the list size - last level results index 0 in the result list
     * Time O(n^2) because every time you add a first index in the list, elements shift to the right 
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root,0);
        return res;
    }
    
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(res.size() <= level){
            res.add(0, new ArrayList<>());
        }
        
        helper(root.left,level+1);
        helper(root.right, level+1);
        res.get(res.size() - level - 1).add(root.val);
    }
}
