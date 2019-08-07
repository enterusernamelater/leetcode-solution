package leetcode.conquer.sol.matrix;

import java.util.HashSet;
import java.util.Set;

/*
 * I think the comment explains this sol pretty well..
 * Time O(mn) Space O(m+n+9)
 */
public class ValidSudoku {
	public ValidSudoku() {}

	public boolean isValidSudoku(char[][] board) {
		if(board == null || board.length == 0) return false;

		Set<Character> ucol = new HashSet<>();
		Set<Character> urow = new HashSet<>();
		Set<Character> ubox = new HashSet<>();

		int m = board.length;
		int n = board[0].length;

		//find dups on col
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(board[i][j] != '.' && ucol.contains(board[i][j])) return false;
				ucol.add(board[i][j]);
			}
			ucol= new HashSet<>();
		}

		//find dups on row
		for(int i=0; i<n; i++){
			for(int j=0; j<m;j++){
				if(board[j][i] != '.' && urow.contains(board[j][i])) return false;
				urow.add(board[j][i]);
			}
			urow = new HashSet<>();
		}

		//now look for 3x3 boxs, transform the board in to a 3x3 board each index has a 3x3 box
		for(int i=1; i<=3; i++){
			for(int j=1;j<=3;j++){
				int row = i*3;
				int col = j*3;

				for(int k=row-1;k>=row-3;k--){
					for(int l=col-1;l>=col-3;l--){
						if(board[k][l] != '.' && ubox.contains(board[k][l])) return false;
						ubox.add(board[k][l]);
					}
				}
				ubox = new HashSet<>();
			}
		}

		return true;
	}
}
