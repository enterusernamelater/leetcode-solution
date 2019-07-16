package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * a two pointer that increments when one is smaller than the another if is the same
 * we add to the arr and we increment pt1 and pt2;
 * we need to sort both arr first.
 * Time O(nlog(n)) Space O(n)
 */
public class IntersectionOfTwoArraysII {
	public IntersectionOfTwoArraysII() {}

	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1.length == 0 || nums2.length == 0) return new int[0];
		int pt1 = 0;
		int pt2 = 0;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> arr = new ArrayList<>();

		while(pt1 < nums1.length && pt2 < nums2.length){
			if(nums1[pt1] < nums2[pt2]){
				pt1++;
			}else if(nums1[pt1] > nums2[pt2]){
				pt2++;
			}else{
				arr.add(nums1[pt1]);
				pt1++;
				pt2++;
			}
		}

		int[] res = new int[arr.size()];
		for(int i=0;i<arr.size();i++)res[i] = arr.get(i);

		return res;
	}
}
