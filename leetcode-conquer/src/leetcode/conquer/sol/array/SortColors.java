package leetcode.conquer.sol.array;

/*
 * a i index scan the whole arr if is 0 we swap to the left if is 2 we swap to the right
 * once a correct left and right value is found we increment left and decrement r
 * note we only increment i when swapping 0 to the left because only swapping 0 to the left
 * guarantees the order. however swap 2 to the right is not for example a right can be 0 to swap with a 2
 * so the next loop we will need to swap the 0 to the left to maintain a proper order
 * Time O(n)
 * Space constant
 */
public class SortColors {
	public SortColors() {}
	
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int l=0;
        int r=nums.length-1;
        int i=0;
        while(i<=r){
            if(nums[i] == 0){
                swap(i++,l++,nums);
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(i,r--,nums);
            } 
        }
    }
    
    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
