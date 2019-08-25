package leetcode.conquer.sol.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * the logic behind this is pretty clear, see comments below or vid link attached:
 * https://www.youtube.com/watch?v=-Tk52eP5n3c
 * Time O(n) Space O(n)
 */
public class MinimumHeightTrees {
	public MinimumHeightTrees() {}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n == 1) return Collections.singletonList(0);

		//map each node with its edges using set
		List<Set<Integer>> list = new ArrayList<>();
		for(int i=0;i<n;i++) list.add(new HashSet<>());

		for(int[] edge : edges){
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		
		//find the initial leaves
		List<Integer> leaves = new ArrayList<>();
		for(int i=0;i<n;i++) 
			if(list.get(i).size()==1) leaves.add(i);

		//move up from leaves one at a time and remove the leave edge from the one up degree's edge set
		//makeing the one up degree node the new leaves if it only has one edge
		//each loop we decrement n by the leaves size
		//loop stop when there is less or equal to 2 nodes in the tree.
		while(n > 2){
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for(int i : leaves){
				int j = list.get(i).iterator().next();
				list.get(j).remove(i);
				if(list.get(j).size() == 1) newLeaves.add(j);
			}

			leaves = newLeaves;
		}
		return leaves;
	}
}
