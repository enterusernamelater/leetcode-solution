package leetcode.conquer.sol.bit.manipulation;
/*
 * We are simulating a very similar approach as of single number I
 * in the previous question we xor each number to get 0 if they are the same
 * in this question we add each bit of all the numbers or all 32 bits. and mod by 3
 * if 3 numbers are the same then the mod result will be 0. in each round of bit addition from
 * 1 to 32 bits, once the result sum is obtained we append it to the final result to its corresponding bit
 * by using a shift to the left and bitwise operation
 * link explained:
 * https://www.youtube.com/watch?v=puXcQpwgcD0
 * Time O(n) space constant
 */
public class SingleNumberII {

	public SingleNumberII() {}
	
	public int singleNumber(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int res = 0;
		for(int i=0;i<32;i++){
			int sum =0;
			for(int num : nums){
				sum += (num >> i) & 1;
			}
			sum %=3;
			res |= sum << i;
		}
		return res;
	}
}
