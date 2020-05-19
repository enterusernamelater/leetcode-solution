package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.TreeNode;

/*
 * compare each node in s to t see if the tree is identical.
 * if not we move on to the next until we find one we return true;
 * otherwise we return false.
 * O(n^2) or O(n*m) m been the tree t
 * space constant
 */
public class SubtreeOfAnotherTree {
	public SubtreeOfAnotherTree() {}
	
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(helper(s,t)) return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    
    private boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        else if(s == null) return false;
        else if(t == null) return false;
        
        return s.val == t.val? helper(s.right,t.right) && helper(s.left,t.left) : false;
    }
}
