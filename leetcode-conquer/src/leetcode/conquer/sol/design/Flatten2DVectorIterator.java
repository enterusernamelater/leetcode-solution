package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * same as the previous logic but using iterator. this question can also be solved by just using a queue
 */
public class Flatten2DVectorIterator {
	Iterator<int[]> i;
	Iterator<Integer> j;
	public Flatten2DVectorIterator(int[][] v) {
		List<int[]> list = new ArrayList<>(Arrays.asList(v));
		this.i = list.iterator();
	}

	public int next() {
		hasNext();
		return j.next();
	}

	public boolean hasNext() {
		while((j == null || !j.hasNext()) && i.hasNext()){
			int[] arr = i.next();
			List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
			this.j = list.iterator();
		}

		return j != null && j.hasNext();
	}
}
