package leetcode.conquer.sol.array;

public class RotateArray {
	/*
	 * no memory allocation, first reverse the whole arr, then reverse the half before k (exclusive)
	 * then reverse the arr after k (inclusive)
	 * then you have your result
	 * Time O(n)
	 * Space constant
	 */
	public void rotate(int[] nums, int k) {
		k = k% nums.length;
		if(k == 0) return;

		int l = 0;
		int r = nums.length-1;

		while(l<r){
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}

		l = 0;
		l = l | r;
		r = k-1;

		while(l<r){
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}

		l = k;
		r = nums.length-1;

		while(l<r){
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}
	}

	/*
	 * this is if you do use memory 
	 * Time O(n)
	 * Space O(n)
	 * basically adding elements after k to the tmp indexes first
	 * then add the ones thats before k after
	 */
	 public void rotateSolTwo(int[] nums, int k) {
		 k = k%nums.length;
		 int[] tmp = new int[nums.length];
		 int j =0;
		 for(int i=nums.length-k;i<nums.length;i++){
			 tmp[j++] = nums[i];
		 }

		 for(int i=0;i<nums.length-k;i++){
			 tmp[j++] = nums[i];
		 }

		 for(int i=0;i<nums.length;i++) nums[i] = tmp[i];
	 }
}
