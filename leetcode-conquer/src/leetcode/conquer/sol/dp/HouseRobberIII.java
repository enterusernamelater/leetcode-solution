package leetcode.conquer.sol.dp;

import leetcode.conquer.tree.TreeNode;

/*
 * dfs with a dp solution that after each post order we return a data object with its previous max and previous before previous max
 * if we use the current val (we steal) we can only use max2 (previous before previous) because they are not adjacent 
 * if we dont pick current node meaning we dont steal current house
 * we can return the max combination between the previous steals and previous not steals
 * Math.max(left.max1, left.max2) + Math.max(right.max1,right.max2);
 * Time O(n)
 * Space constant
 * 
 */
public class HouseRobberIII {
	public HouseRobberIII() {}
	
    public int rob(TreeNode root) {
        if(root == null) return 0;
        
        Data data = helper(root);
        return Math.max(data.max1, data.max2);
    }
    
    private Data helper(TreeNode root){
        if(root == null) return new Data(0,0);
        
        Data left = helper(root.left);
        Data right = helper(root.right);
        
        int val1 = root.val + left.max2 + right.max2;
        int val2 = Math.max(left.max1, left.max2) + Math.max(right.max1,right.max2);
        return new Data(val1,val2);
    }
    
    class Data{
        public int max1 = 0;
        public int max2 = 0;
        
        public Data(int max1, int max2){
            this.max1 = max1;
            this.max2 = max2;
        }
    }
}
