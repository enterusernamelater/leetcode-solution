package leetcode.conquer.sol.array;

/*
 * i 是在填位子， j在扫描合适的数， 不等于target的数
 * Time O(n) Space constant
 */
public class RemoveElement {
	public RemoveElement() {}
	
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length ==0) return 0;
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
