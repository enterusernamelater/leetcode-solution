package leetcode.conquer.sol.array;

/*
 * two pointer, one pointer updates the second points of its previous
 * indicating the diff one has found
 * return i+1 as turn last index to the size
 * Time O(n) Space (1)
 */
public class RemoveDuplicatesFromSortedArray {
	public RemoveDuplicatesFromSortedArray() {}
	
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[j-1]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
