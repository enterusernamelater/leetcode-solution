package leetcode.conquer.sol.recursion;

import java.util.Arrays;

/*
 * DFS
 * this is a same sol as NQueens 1
 * just dont build the res array
 * this time is o(n!)
 * space o(n) for worst case
 */
public class NQueensII {

	public NQueensII() {}

	private int res = 0;
	private boolean[] col;
	private boolean[] diagl;
	private boolean[] diagr;
	private int n;

	public int totalNQueens(int n) {
		if(n == 0) return res;
		this.col = new boolean[n];
		this.diagl = new boolean[2*n-1];
		this.diagr = new boolean[2*n-1];
		this.n = n;

		helper(0);
		return res;
	}

	private void helper(int i){
		if(i==n){
			res++;
			return;
		}

		for(int j=0; j<n; j++){
			if(notAvailable(i,j)) continue;
			update(i,j,true);
			helper(i+1);
			update(i,j,false);
		}
	}

	private boolean notAvailable(int i, int j){
		return col[j] || diagl[i+j] || diagr[n-1+j-i];
	}

	private void update(int i, int j, boolean isUsed){
		col[j] = isUsed;
		diagl[i+j] = isUsed;
		diagr[n-1+j-i] = isUsed;
	}
}
