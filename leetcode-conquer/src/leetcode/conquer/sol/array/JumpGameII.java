package leetcode.conquer.sol.array;
/*
 * very similar to the first JumpGame find max extend distance within the current jump limit
 * when the current jump limit reaches the end, we update the current jump limit to the max we found earlier
 * Increment the jump as we have performed a jump so the jump limit has increased.
 * Time O(n), space constant
 */
public class JumpGameII {
	public JumpGameII() {}
	
    public int jump(int[] nums) {
        int jump = 0;
        int distance = 0;
        int nextDistance = 0;
        for(int i=0; i<=distance;i++){
            //check if the distance has eached the end
            if(distance >= nums.length-1) return jump;
            nextDistance = Math.max(nextDistance,nums[i]+i);
            if(i==distance){
                jump++;
                distance = nextDistance;
            }
        }

        return -1;
    }
}
