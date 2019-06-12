package leetcode.conquer.sol.dp;

import java.util.List;

/*
 * this is a dp soltuion one layer's result is based on the layer above 
 * until we reach the end and then find the min in the end
 * Time O(n) where n is the size of the triangle.
 * Space O(1)
 */
public class Triangle {
	public Triangle() {}

	public int minimumTotal(List<List<Integer>> t) {
		if(t == null || t.size() ==0) return 0;
		int size = t.size();

		for(int i=0;i<size; i++){
			for(int j=0; j<=i; j++){
				if(i==0 && j ==0) continue;
				if(j==0){
					t.get(i).set(j, t.get(i).get(j) + t.get(i-1).get(j)); 
				}else if(j==i){
					t.get(i).set(j, t.get(i).get(j) + t.get(i-1).get(j-1)); 
				}else{
					t.get(i).set(j,t.get(i).get(j) + Math.min(t.get(i-1).get(j-1), t.get(i-1).get(j)));
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for(int i=0; i<t.get(size-1).size();i++)
			res = Math.min(res,t.get(size-1).get(i));

		return res;
	}
}
