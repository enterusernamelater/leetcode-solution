package leetcode.conquer.sol.array;

import java.util.*;
public class IntervalListIntersections {
	public IntervalListIntersections() {}
	
	public int[][] intervalIntersection(int[][] A, int[][] B){
		List<int[]> list = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		while(i1<A.length && i2<B.length) {
			int l = Math.max(A[i1][0], B[i2][0]);
			int h = Math.min(A[i1][1], B[i2][1]);
			
			if(l<=h) list.add(new int[] {l,h});
			
			if(A[i1][1] < B[i2][1]) {
				i1++;
			}else {
				i2++;
			}
		}
		
		return list.toArray(new int[list.size()][]);
	}
}
