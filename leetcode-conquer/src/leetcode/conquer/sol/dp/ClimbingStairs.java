package leetcode.conquer.sol.dp;

/*
 * time O(n) space O(1)
 * a detailed explanation on this question can be found in this video
 * https://www.youtube.com/watch?v=LpsDWvkd-4Q
 */
public class ClimbingStairs {
	
	public ClimbingStairs() {}
	
    public int climbStairs(int n) {
        int cur = 1;
        int prev = 1;

        for(int i=2; i<=n;i++){
            int tmp = cur;
            cur = cur + prev;
            prev = tmp;
        }
        
        return cur;
    }
}
