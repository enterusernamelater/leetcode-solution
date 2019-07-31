package leetcode.conquer.sol.binarysearch;

/*
 * a very nice binary search solution for this problem
 * the left will be the max val because if you split every element in the arr the max will be the max sum
 * the right will be the total sum because if you dont split at all (1 split) the total sum is the boundary
 * now we do binary search on left to right to find the minium sum that is with in the m
 * Time O(Log(n)) Space constant
 * 
 */
public class SplitArrayLargestSum {

	public SplitArrayLargestSum() {}

	public int splitArray(int[] nums, int m) {
		int max = 0;
		int sum = 0;
		for(int num : nums){
			max = Math.max(num,max);
			sum+=num;
		}

		int low = max;
		int high = sum;

		while(low < high){
			int mid = low + (high-low)/2;
			int pieces = split(nums,mid);
			if(pieces > m){
				low = mid + 1;
			}else{
				high = mid;
			}
		}
		return low;
	}

	private int split(int[] nums, int maxSum){
		int pieces = 1;
		int tmp =0;

		for(int num : nums){
			if(tmp + num > maxSum){
				pieces++;
				tmp = num;
			}else{
				tmp += num;
			}
		}

		return pieces;
	}
}
