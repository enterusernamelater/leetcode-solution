package leetcode.conquer.sol.dp;

/*
 * a dp solution with 
 * Time O(n) Space O(n)
 * detailed explanation is below:
 * https://www.youtube.com/watch?v=fmpP5Ll0Azc
 */
public class UniquePaths {
	public UniquePaths() {}
    private int[][] table;
    public int uniquePaths(int m, int n) {
        this.table = new int[m+1][n+1];
        table[1][1] = 1;
        for(int i=1; i<=m;i++)
            for(int j=1; j<=n;j++)
                table[i][j] = i==1 && j ==1? 1 : table[i-1][j] + table[i][j-1];
          
        return table[m][n];
    }
}

