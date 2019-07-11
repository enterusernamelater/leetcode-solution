package leetcode.conquer.sol.dp;

/*
 * This is a dp + memorization solution 
 * killr is the total 'e' to kill in the current row for the current pos until the first 'w'
 * killc keep track the total e to kill for the col j until its first 'w'
 * both killr and killc[j] resets in the first row/col or a wall is hit.
 * 
 * then the killr and killc[j] sum is used to calculate the max res;
 * link to this question is below:
 * https://www.youtube.com/watch?v=X3WrZG08ns8
 * Time O(n), Space O(n)
 */
public class BombEnemy {
	public BombEnemy() {}

	public int maxKilledEnemies(char[][] grid) {
		if(grid.length == 0) return 0;
		int h = grid.length;
		int w = grid[0].length;
		int killr = 0;
		int[] killc = new int[w];
		int res = 0;

		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				if(j==0 || grid[i][j-1] == 'W'){
					killr = 0;
					for(int k=j;k<w && grid[i][k] != 'W';k++){
						if(grid[i][k] == 'E'){
							killr++;
						}
					}
				}

				if(i == 0 || grid[i-1][j] == 'W'){
					killc[j] = 0;
					for(int k = i; k<h && grid[k][j] != 'W'; k++){
						if(grid[k][j] == 'E'){
							killc[j]++;
						}
					}
				}

				if(grid[i][j] == '0'){
					res = Math.max(res, killr+killc[j]);
				}
			}
		}

		return res;
	}
}
