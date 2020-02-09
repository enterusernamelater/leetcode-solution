package leetcode.conquer.sol.array;

import java.util.HashSet;
import java.util.Set;

/*
 * a two sum solution with a twist since we are looking for a=2*b
 * Time O(n)
 * Space O(n)
 */
public class CheckIfNAndItsDoubleExist {
	public CheckIfNAndItsDoubleExist() {}

	public boolean checkIfExist(int[] arr) {
		Set<Double> set = new HashSet<>();
		double two = 2.0;
		for(int i=0;i<arr.length;i++){
			double val = (double)arr[i];
			if(set.contains(val*two) || set.contains(val/two)) return true;
			set.add(val);
		}

		return false;
	}
}
