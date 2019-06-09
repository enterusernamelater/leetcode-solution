package leetcode.conquer.sol.recursion;

/*
 * a recursive sol based on dp 
 * Time O(m*n) Space O(m*n)
 */
public class UniquePathsRecursiveSol {
	public UniquePathsRecursiveSol() {}
	
    private int[][] table;
    public int uniquePaths(int m, int n) {
        this.table = new int[m+1][n+1];
        return helper(m,n);
    }
    
    private int helper(int m, int n){
        if(m<=0 || n<=0) return 0;
        if(m == 1 && n == 1) return 1;
        if(table[m][n] > 0) return table[m][n];
        table[m][n] = helper(m-1,n) + helper(m,n-1);
        return table[m][n];
    }
}
