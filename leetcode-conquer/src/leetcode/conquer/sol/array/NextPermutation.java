package leetcode.conquer.sol.array;

/*
 * this is a solution taken from youtube: https://www.youtube.com/watch?v=9mdoM2dVid8
 * the idea is based on the lexicographically order. we increment lexicographically order by finding the 
 * previous index that is smaller than the next index. once we found this previous index, we now know there is a 
 * next greater lexicographically order. if we not found(firstSmall is -1) the we know this order array nums has reached to the end
 * we simplity swap the nums and return.  
 * if found, the we now do a second loop finding the first large index that is greater than the previous index we have found. 
 * the reason of doing this is due to the lexicographically order, we want to find the smallest large index that is greater than the previous index.
 * once found we swap the previous index(firstSmall) and the smallest large index(firstLarge), then swap the sub array of nums from firstSmall+1 to the end of 
 * nums.length because due to lexicographically order. the beginning of the order is the swap of the end, for example, 3,2,1 is the end, we swap to 1,2,3 which is the 
 * beginning.
 * time o(n), space o(1) 
 */
public class NextPermutation {
	public NextPermutation() {}
	
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int firstSmall = -1;
        for(int i = nums.length-2; i>=0;i--){
            if(nums[i]<nums[i+1]){
                firstSmall = i;
                break;
            }
        }
        if(firstSmall == -1){
            int l = 0;
            int r = nums.length-1;
            while(l<r)
                swap(l++,r--,nums);
            
            return;
        }
        
        int firstLarge = -1;
        for(int i= nums.length-1;i>firstSmall;i--){
            if(nums[i]>nums[firstSmall]){
                firstLarge = i;
                break;
            }
        }
        
        swap(firstSmall,firstLarge,nums);
        int l=firstSmall+1;
        int r= nums.length-1;
        while(l<r)
            swap(l++,r--,nums);
        
    }
    
    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
