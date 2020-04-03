package leetcode.conquer.sol.array;

/*
 * two pointers solution, i always lands on the first zero index for the next swap
 * Time O(N)
 * Space constant
 */
public class MoveZeroes {
	public MoveZeroes() {}
	
    public void moveZeroes(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
    }
}
