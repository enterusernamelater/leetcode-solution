package leetcode.conquer.sol.union.fInd;

import java.util.Arrays;

/*
 * this is the a union find alg first we add x and y into a set where x is the index and y is the val
 * we starting the x indexes with val of -1
 * then we look at each edges both sides val and check if any edge val happens to be in the same set 
 * to do this we find the edge val by looking for the end of the merge set to add 
 * if passing in both edge val into the merge set returns the same end, we know they are in the same set return false
 * because we found a cycle. this check continues to the end
 * in the end, we check if the total edges is the total nodes - 1 as the tree property
 * link explains union find alg to valid undirected graph
 * https://www.youtube.com/watch?v=mHz-mx-8lJ8
 * Time O(n) Space O(n)
 * 
 * Note, the union set nums is basically a tree with the parent being the value. root[c] = p
 */
public class GraphValidTree {
	
	public GraphValidTree() {};
	
    public boolean validTree(int n, int[][] edges) {
        //union find first we make all nodes its single subset
        int[] nums = new int[n];
        Arrays.fill(nums,-1);
        
        for(int i=0; i<edges.length; i++){
            int x = find(nums,edges[i][0]);
            int y = find(nums,edges[i][1]);
            
            //if x and y are in the same subset we return false;
            if(x==y) return false;
            
            nums[x] = y;
        }
        
        //in tree the total edges is the total vertices - 1 
        return edges.length == n-1;
    }
    
    private int find(int[] nums, int val){
        //if this is the end of the subset we return the val
        if(nums[val] == -1) return val;
        return find(nums,nums[val]);
    }
}
