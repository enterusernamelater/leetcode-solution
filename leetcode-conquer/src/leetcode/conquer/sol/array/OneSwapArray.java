package leetcode.conquer.sol.array;

public class OneSwapArray {
	public OneSwapArray() {}
	
	public boolean oneSwapArray(int[] nums) {
		if(nums == null || nums.length == 0) return false;
		int n = nums.length;

		//find first large from right
		int i=0;
		for(i=n-1;i>0;i--) {
			if(nums[i]<nums[i-1]) {
				while(i+1<nums.length && nums[i] == nums[i+1])i++;
				break;
			}
		}
		//if nothing found meaning is sorted;
		if(i==0) return false;
		int r = i;
		
		for(i=0;i<nums.length-1;i++) {
			if(nums[i] > nums[i+1]) {
				while(i-1>=0 && nums[i] == nums[i-1]) i--;
				break;
			}
		}
		int l=i;
		
		//swap
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
		
		for(i=1;i<nums.length;i++) {
			if(nums[i] < nums[i-1]) return false;
		}
		
		return true;
	}
}
