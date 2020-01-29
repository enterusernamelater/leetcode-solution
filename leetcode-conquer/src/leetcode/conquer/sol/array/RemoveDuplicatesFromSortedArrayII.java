package leetcode.conquer.sol.array;

/*
 * a two pointer, i moves with j on finding pairs once a double pair found, the found boolean flip to true
 * and i stay at the end of the double pair until j encounters the different pair
 * i is behind or same to j and always changing the array value. the change value stops when found is true meaning
 * i now need to wait for j to find new different pairs to replace the duplicates on i
 * when i and j are in the same pace and found is false. nums[i] = nums[j] makes no difference
 * Time O(n)
 * Space constant
 */
public class RemoveDuplicatesFromSortedArrayII {
	RemoveDuplicatesFromSortedArrayII(){}
	
    public int removeDuplicates(int[] nums) {
        boolean found = false;
        int i =1;
        
        for(int j=1; j<nums.length; j++){
            if(!found && nums[j] == nums[j-1]){
                found = true;
                nums[i++] = nums[j];
            }else if(nums[j] != nums[j-1]){
                found = false;
                nums[i++] = nums[j];
            }
            
        }
        return i;
    }
}
