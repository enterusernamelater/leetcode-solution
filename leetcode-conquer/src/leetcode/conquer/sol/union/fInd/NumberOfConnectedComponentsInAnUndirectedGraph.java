package leetcode.conquer.sol.union.fInd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This is the same alg as the graph valid tree question the only difference is that
 * when we encounter a cycle, meaning x and y are in the same set 
 * instead of doing anything we skip change val on nums[x] = y this way
 * we everything else is right the nums arr will only contain a -1
 * which is the right res to return
 * 
 * Note, the union set nums is basically a tree with the parent being the value. root[c] = p
 * Time O(n) Space O(n)
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
	public NumberOfConnectedComponentsInAnUndirectedGraph() {}

	public int countComponents(int n, int[][] edges) {
		int[] nums = new int[n];
		Arrays.fill(nums,-1);
		for(int i=0;i<edges.length;i++){
			int x = find(nums,edges[i][0]);
			int y = find(nums,edges[i][1]);
			 //usually if x == y then there is a cycle detact
			if(x!=y) nums[x] = y;
		}

		int res = 0;
		for(int i : nums) if(i == -1) res++;

		return res;
	}

	private int find(int[] nums, int val){
		if(nums[val] == -1) return val;
		return find(nums,nums[val]);
	}
	
	//dfs solution
    public int countComponentsDFS(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        int[] v = new int[n];
        
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        
        for(int[] e : edges){
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        int res = 0;
        
        for(int i=0;i<n;i++){
            if(v[i] == 1) continue;
            res++;
            helper(g,v,i);
        }
        
        return res;
    }
    
    private void helper(List<List<Integer>> g, int[] v, int curr){
        if(v[curr] == 1) return;
        v[curr] =1;
        List<Integer> list = g.get(curr);
        for(int node : list){
            helper(g,v,node);
        }
    }
}
