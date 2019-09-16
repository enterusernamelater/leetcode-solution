package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * turn a+b+c+d=e to a+b=e-c-d this is now a two sum.
 * two for loop select the the c and d then a while from l and r finding the proper while
 * skip dup by using while loop 
 * very similar solution to threesum
 * Time O(n^3) space constant besides the result
 */
public class FourSum {
	public FourSum() {}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums == null || nums.length == 0) return new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3;i++){
			if(i>0 && nums[i-1] == nums[i]) continue;
			for(int j=i+1; j<nums.length-2;j++){
				if(j>i+1 && nums[j-1] == nums[j]) continue;
				int val = target - nums[i] - nums[j];
				int l = j+1;
				int r = nums.length-1;
				while(l<r){
					int sum = nums[l] + nums[r];
					if(sum > val){
						while(l<r && nums[r] == nums[r-1]) r--;
						r--;
					}else if(sum < val){
						while(l<r && nums[l] == nums[l+1]) l++;
						l++;
					}else{
						res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[l],nums[r])));
						while(l<r && nums[r] == nums[r-1]) r--;
						while(l<r && nums[l] == nums[l+1]) l++;
						r--;
						l++;
					}
				}
			}
		}
		return res;
	}
}
