package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * a+b+c=0 is a+b=-c use this equation to turn this into a two sum question
 * then using a l and r pointer to find the proper sum num1 and num2 
 * use while loop to avoid dups
 * Time O(n^2) Space constant
 */
public class ThreeSum {
	public ThreeSum() {}

	public List<List<Integer>> threeSum(int[] nums) {
		if(nums == null || nums.length < 3) return new ArrayList<>();
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i] == nums[i-1]) continue;
			int l = i+1;
			int r = nums.length-1;
			int target = -nums[i];
			while(l<r){
				int sum = nums[l] + nums[r];
				if(sum > target){
					while(l<r && nums[r] == nums[r-1]) r--;
					r--;
				}else if(sum < target){
					while(l<r && nums[l] == nums[l+1]) l++;
					l++;
				}else{
					res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
					while(l<r && nums[r] == nums[r-1]) r--;
					while(l<r && nums[l] == nums[l+1]) l++;
					r--;
					l++;
				}
			}
		}

		return res;
	}
}
