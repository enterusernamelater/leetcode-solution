package leetcode.conquer.sol.binarysearch;

/*
 * the single element will always land at the even index. so when mid is even we compare with mid +1 odd we compare mid-1
 * this way we are sure that everything before mid is all duplicates if they are equal. if they are not equal we move r to the mid
 * as assuming r is the single no duplicate until a new delta case found then r moves to the new mid. eventually r will land on the right 
 * no duplicate index. when that happens l will catch up eventually break the loop
 * https://www.youtube.com/watch?v=uJa9Q-05JxY
 * Time O(n) Space constant
 */
public class SingleElementInASortedArray {
	public SingleElementInASortedArray() {}
	
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            
            if(mid%2 == 0){
                if(nums[mid] != nums[mid+1]) r = mid;
                else l = mid + 1;
            }else{
                if(nums[mid] != nums[mid-1]) r = mid;
                else l = mid + 1;
            }
        }
        
        return nums[l];
    }
}
