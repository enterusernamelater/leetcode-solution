package leetcode.conquer.sol.dp;

import java.util.Collections;
import java.util.TreeSet;

/*
 * the time complexity for this one is O(w^2 * h) space complexity is O(h)
 * the logic behind is for based on the vid below:
 * https://www.youtube.com/watch?v=yCQN096CwWM
 * following the logic we then using treeset to find the max sum that is less than k for each sum[] calculation
 * the idea of use treeset is this.
 * when a rectangle's sum[] formed we use Kadane's alg to find the max sum for the sub array in sum[] that is less than k
 * to do this we will need a treeset's ceiling method. 
 */
public class MaxSumOfRectangleNoLargerThanK {
	public MaxSumOfRectangleNoLargerThanK() {}

	public int maxSumSubmatrix(int[][] m, int k) {
		if(m == null || m.length == 0) return 0;
		int h = m.length;
		int w = m[0].length;

		int max = Integer.MIN_VALUE;
		for(int i=0; i<w; i++){
			int[] sum = new int[h];
			for(int j=i; j<w;j++){
				for (int i1=0;i1<h;i1++){
					sum[i1] += m[i1][j];
				}
				max = Math.max(max, findMax(sum,k));
			}
		}
		return max;
	}

	private int findMax(int[] sum, int k){
		TreeSet<Integer> s = new TreeSet<>(Collections.singleton(0));

		int val = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<sum.length; i++){
			//Kadane's alg to find the sub array sum on each index increment. 
			val += sum[i];
			/* find the difference on the current sub-array sum with k
			 * if delta doesn't exists meaning if sub-array sum is less than k
			 * val-k will return negative and ceiling(val-k) will return 0 which is the initial value
			 * so the max will be calculated on the current sub-array sum
			 * if val-k > 0, ceiling(val-k) returns the closest sub-array sum we store before 
			 * that is greater than the val-k. we call this delta and we use the current sub-array sum val-delta
			 * to get the sub-array sum that is guarrented to be less than k and find the max using this sum.
			 */
			
			Integer delta = s.ceiling(val-k);
			max = delta == null? max : Math.max(max,val-delta);
			s.add(val);
		}

		return max;
	}
}
