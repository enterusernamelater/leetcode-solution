package leetcode.conquer.sol.linkedlist;

import java.util.*;


public class MergeKsortedListIterator {
	public MergeKsortedListIterator() {}
	
	public List<Integer> mergeKLists(List<List<Integer>> list) {
		return merge(list,0,list.size()-1);
	}

	private List<Integer> merge(List<List<Integer>> list, int s, int e) {
		if(s == e) return list.get(s);
		int mid = (s+e) >> 1;
		List<Integer> left = merge(list,s,mid);
		List<Integer> right = merge(list,mid+1,e);
		
		return mergeTwoListIteratorStyle(left,right);
	}

	private List<Integer> mergeTwoListIteratorStyle(List<Integer> left, List<Integer> right) {
		if(left.isEmpty() && right.isEmpty()) return new ArrayList<>();
		
		Iterator<Integer> iterator1 = left.iterator();
		Iterator<Integer> iterator2 = right.iterator();
		List<Integer> res = new ArrayList<>();
		
		int val1 = iterator1.hasNext()? iterator1.next() : Integer.MAX_VALUE, val2 = iterator2.hasNext()? iterator2.next() : Integer.MAX_VALUE;

		while(iterator1.hasNext() && iterator2.hasNext()) {
			if(val1 < val2) {
				res.add(val1);
				val1 = iterator1.next();
			}else {
				res.add(val2);
				val2 = iterator2.next();
			}
		}
		
		if(res.isEmpty()) {
			if(val1<val2) {
				res.add(val1);
			}else {
				res.add(val2);
			}
		}
		
		while(iterator2.hasNext()) {
			res.add(iterator2.next());
		}
		
		while(iterator1.hasNext()) {
			res.add(iterator1.next());
		}
		
		return res;
	}
}
