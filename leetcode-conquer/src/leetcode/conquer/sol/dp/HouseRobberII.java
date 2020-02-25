package leetcode.conquer.sol.dp;

/*
 * same logic as the first house robber question take either the previous or the current plus the previous before the previous
 * since its now a circle we first start without the first house but include the end
 * then we start with the first house but exclude the end.
 * Time O(N)
 * Space Constant
 */
public class HouseRobberII {
	public HouseRobberII() {}
	
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int p1 = 0;
        int p2 = nums[0]; //start with the first house but exclude the last 
        for(int i=1;i<nums.length-1;i++){
            int save = p2;
            p2 = Math.max(p2, nums[i] + p1);
            p1 = save;
        }
        
        int max1 = p2;
        p1 = 0;
        p2 = nums[1]; //start without the first house but include the last
        for(int i=2;i<nums.length;i++){
            int save = p2;
            p2 = Math.max(p2,nums[i]+p1);
            p1 = save;
        }
        
        //find the max between the above two tries.
        return Math.max(max1,p2);
    }
}
