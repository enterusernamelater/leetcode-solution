package leetcode.conquer.sol.binarysearch;

import java.util.ArrayList;
import java.util.List;

/*
 * This is more a merge sort solution but we starting merge sort but actually sorting its indexes
 * each round of the sort we keep a rightCount which represents numbers that are smaller than the left number
 * when finally a right number that is greater than the left number reached we update the count[] by using the left number index
 * using the sorted index arr
 * with the rightCount, we dont reset rightCount because both side left and right are sorted. if next right is smaller than the current left
 * meaning the previous right will have to be smaller than the current left as well.
 * finally we dump the count arr into an arraylist and return the result.
 * Time O(nlog(n)) Space O(n)
 */
public class CountOfSmallerNumbersAfterSelf {
	
	public CountOfSmallerNumbersAfterSelf() {}

	private List<Integer> res = new ArrayList<>();
	private int n;
	private int[] nums;
	private int[] count;

	public List<Integer> countSmaller(int[] nums) {
		if(nums.length == 0) return res;
		this.n = nums.length;
		this.nums = nums;

		this.count = new int[n];
		int[] indexes = new int[n];

		for(int i=0;i<n;i++) indexes[i] = i;

		mergeSort(indexes, 0, n-1);

		for(int i=0; i<n; i++) res.add(count[i]);

		return res;
	}

	private void mergeSort(int[] indexes, int start, int end){
		if(start == end) return;

		int mid = (start+end)/2;

		mergeSort(indexes,start,mid);
		mergeSort(indexes,mid+1,end);

		int[] sortArr= new int[end-start+1];

		int leftStart= start;
		int leftEnd = mid;
		int rightStart = mid+1;
		int rightEnd = end;

		int rightCount = 0;
		int sortIndex = 0;

		while(leftStart<=leftEnd && rightStart<=rightEnd){
			if(nums[indexes[leftStart]] > nums[indexes[rightStart]]){
				rightCount++;
				sortArr[sortIndex++] = indexes[rightStart++];
			}else{
				count[indexes[leftStart]] += rightCount;
				sortArr[sortIndex++] = indexes[leftStart++];
			}
		}

		while(leftStart <= leftEnd){
			count[indexes[leftStart]] += rightCount;
			sortArr[sortIndex++] = indexes[leftStart++];
		}

		while(rightStart <= rightEnd){
			sortArr[sortIndex++] = indexes[rightStart++];
		}

		for(int i=start; i<=end; i++){
			indexes[i] = sortArr[i-start];
		}
	}
}
