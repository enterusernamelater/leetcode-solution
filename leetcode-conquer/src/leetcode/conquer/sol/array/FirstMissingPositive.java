package leetcode.conquer.sol.array;

/*
 * see comment for explanation, youtube link for this solution below:
 * https://www.youtube.com/watch?v=jfb72FfxWKU
 * complexity O(n) with the worst to be 2n. its possible the while loop need to loop all n to 
 * arrange each nums[i] to its proper index. but no more while after. for loop simply continues to the end.
 * space constant O(1)
 */
public class FirstMissingPositive {
	public FirstMissingPositive() {}
	
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        
        for(int i=0;i<nums.length;i++){
            //check if the nums[i] is a valid postive number and if the number is in its proper location
            //the proper location should be 1+ its own index for example index 0,1,2,3 match to proper array 1,2,3,4
            //its a while loop because the next nums[i] can still be in a invalid index need to continue swap until
            //this round all touched index numbers are in their proper location.
            while(nums[i]>0 && nums[i]<nums.length && nums[nums[i]-1] != nums[i]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        //above for loop + while loop sorts all invalid nums[i]s to their proper location
        //once sorted, the first invalied index will be the first missing positive.
        for(int i=0;i<nums.length;i++){
            if(i+1 != nums[i]) return i+1;
        }
        
        return nums.length+1;
    }
}
