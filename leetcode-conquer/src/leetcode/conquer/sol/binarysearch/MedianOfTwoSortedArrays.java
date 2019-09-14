package leetcode.conquer.sol.binarysearch;

/*
 * This is a really hard binary search question..I really dont want to explain this question,
 * the first 10 mintues of this video explains the question better than me..
 * https://www.youtube.com/watch?v=do7ibYtv5nk
 * Time O(log(min(nums1,nums2))) space constant.
 */
public class MedianOfTwoSortedArrays {
	public MedianOfTwoSortedArrays() {}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) return findMedianSortedArrays(nums2,nums1);
		int mid1 = 0;
		int mid2 = 0;
		int l = 0;
		int r = nums1.length;

		int n = nums1.length + nums2.length;

		while(l<=r){
			mid1 = (l+r) >> 1;
		mid2 = n/2 - mid1;

		double l1 = (mid1-1 >= 0 && mid1-1<nums1.length)? nums1[mid1 - 1] : Integer.MIN_VALUE;
		double l2 = (mid2-1 >= 0 && mid2-1<nums2.length)? nums2[mid2 - 1] : Integer.MIN_VALUE;
		double r1 = (mid1 >= 0 && mid1 < nums1.length)? nums1[mid1] : Integer.MAX_VALUE;
		double r2 = (mid2 >= 0 && mid2 < nums2.length)? nums2[mid2] : Integer.MAX_VALUE;

		if(l1>r2){
			r = mid1 - 1;
		}else if(l2>r1){
			l = mid1 + 1;
		}else{
			if(n%2 == 0){
				l1 = Math.max(l1,l2);
				r1 = Math.min(r1,r2);
				return (l1+r1)/2;
			}else{
				return Math.min(r1,r2);
			}
		}
		}
		return -1;
	}
}
