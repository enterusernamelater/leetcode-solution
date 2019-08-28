package leetcode.conquer.sol.union.fInd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * the idea of this question is using union find alg, we first decrement dimension into one dimension
 * then after that we use formula idx = n*x + y to find the proper index on the arr[n*m]
 * we use the arr[n*m] roots to track the pos is an island or no. first when given a pos 
 * we update the pos's index in the roots to its index indicating the pos has one island and increment the count by 1
 * then we check the surround +1,-1 x and +1 , -1 y see if any neighbor island exists, if so we need to update the current pos's index val
 * in the roots to the neighbor island's idx val (the parent val) and decrement the count as now we are merging two island set into one.
 * this process continues until all +1,-1 x and +1 , -1 y are found.
 * in the end, after each check on each given pos we add the current count into the res arr
 * see comments below for detailed explanation.
 * Time O(mnlog(mn)) the mn is the total graph length as it is possible (worst case) that we will need to check all pos in the graph depending
 * on the given positions. log(mn) represents each time the pos is looped the check on the parent root of the neighbor island
 * Space O(m*n)
 */
public class NumberOfIslandsII {
	public NumberOfIslandsII() {}

	private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		int[] roots = new int[m*n];
		Arrays.fill(roots,-1);

		List<Integer> res = new ArrayList<>();
		int count = 0;

		for(int[] pos : positions){
			int root = n*pos[0] + pos[1];
			//skip if the current pos is already found which means there is already a island found
			if(roots[root] != -1){
				res.add(count);
				continue;
			}
			roots[root] = root;
			//increment the number of island
			count++;
			
			//now check all 4 pos of the current pos see if any exising found island if so
			//we need to update the current pos's roots[pos] value to the existing found island's root
			//this is the union set merge.
			for(int[] dir : dirs){
				int i = pos[0] + dir[0];
				int j = pos[1] + dir[1];
				int newIdxPos = n*i + j;
				//越界 or the newIdxPos is empty -1 skip
				if(i<0 || i>=m || j<0 || j>=n || roots[newIdxPos] == -1) continue;

				int newRoot = find(roots,newIdxPos);
				if(newRoot != root){
					//when a neighbor parent root found that is not the current parent root. we need to update the 
					//current pos root to the neighbor parent root as merging two island into one and decrement 
					//the total island count.
					roots[root] = newRoot;
					root = newRoot;
					count--;
				}
			}
			res.add(count);
		}
		return res;
	}

	private int find(int[] root, int val){
		//when find, we check if the given val is the root index itself. if so
		//meaning the val is its own parent
		//otherwise we get the val from root[val] and check the index at val see if the parent is found
		//once the parent is found return the parent.
		//time complexity here is O(logn)
		while(val != root[val]) val = root[val];
		return val;
	}
}
