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
	
	/*
	 * my solution as said at the top we start from bottom right top left and try to reach the king
	 * each index we traveled we find out what is the minimum left over blood required to get to queen from this index.
	 * this is done by comparing the index's right and bottom left over blood requirement (if out of range then just one of them) 
	 * minus the blood on the current index, find the min between them. if the current index blood is negative meaning king is going to lose blood
	 * will increase the total blood requirement on this index to get to the queen. vice versa if blood is positive will decrease the total
	 * blood requirement to get to the queen
	 * note if the total blood requirement to get to the queen is less than 1 we need to set the current index blood requirement to 1
	 * as from this index to queen the starting health can be just 1
	 * starting health cannot be 0 or king will die :)
	 * Time O(M*N)
	 * Space O(M*N)
	 */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] dp = new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j == n-1){
                    dp[i][j] = dungeon[i][j] < 0? -dungeon[i][j] + 1 : 1;
                }else{
                	//if out of range is int max so val1 ignored vice versa
                    int val1 = i+1 < m? dp[i+1][j] - dungeon[i][j] : Integer.MAX_VALUE;
                    if(val1 < 1) val1 = 1; //reset to 1 when current index to queen blood required is negative. that means we only need 1 blood
                    int val2 = j+1 < n? dp[i][j+1] - dungeon[i][j] : Integer.MAX_VALUE;
                    if(val2 < 1) val2 = 1;
                    dp[i][j] = Math.min(val1,val2);
                }
            }
        }

        return dp[0][0];
    }
    
	public int calculateMinimumHPSolTwo(int[][] dungeon) {
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
