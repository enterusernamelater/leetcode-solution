package leetcode.conquer.sol.array;

/*
 * the solution is the same concept as finding linkedlist cycle 
 * only difference is how we start the walker and runner, in checking linked list cycle 
 * the while statement checks the runner's next positions and
 * the equal check happens inside the while loop, we do this because of the null checks on the next.
 * but for an given array there is no next position check therefore we cannot have ptr1 and ptr2 starts at nums[0]
 * so we start ptr1 with one jump and ptr2 with two jump. so now the while statement can check if ptr1 == ptr2
 * once a meeting point found we track from the start of the arr and the meeting point until a joint point reached
 * just like what we did for the linked list cycle
 * the joint point will be the duplicate
 * Time complexity O(n)
 * Space constant
 */
public class FindTheDuplicateNumber {
	public FindTheDuplicateNumber() {}
	
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ptr1 = nums[nums[0]];
        int ptr2 = nums[ptr1];
        
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1]; // jumps onces
            ptr2 = nums[nums[ptr2]];
        }
        
        ptr1 = nums[0];
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
}
