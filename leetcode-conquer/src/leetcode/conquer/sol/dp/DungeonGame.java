package leetcode.conquer.sol.dp;

import java.util.Arrays;

/*
 * The key to this question is starting from bottom to top.
 * This means we will need to calculate the min LEFT OVER blood from bottom right to the left top
 * because if we start from top right to bottom left. we have no clue how much blood we should have when we encounter a + blood index.
 * a detailed explanation video can be found in this link:
 * https://www.youtube.com/watch?v=pt-xIS6huIg
 * Time O(h*w) Space O(h*w)
 */
public class DungeonGame {
	public DungeonGame() {}
	
	public int calculateMinimumHP(int[][] dungeon) {
        int h = dungeon.length;
        int w = dungeon[0].length;
        
        int[][] dp = new int[h+1][w+1];
        
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[h][w-1]=1;
        dp[h-1][w]=1;
        
        for(int i=h-1;i>=0;i--){
            for(int j=w-1;j>=0;j--){
                dp[i][j] =Math.max(1, Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
            }
        }
        
        return dp[0][0];
    }
}
