package leetcode.conquer.sol.recursion;

/*
 * studied based on the link below. typical backtracking problem.
 * keep going to find surrounding 4 letter seek for match. if match the continue to search next 4 letters.
 * if not, loop continues to another letter and word count 'd' resets to 0. 
 * return true if matches meaning 'd' reaches to the end. 
 * time o(m*n*4^l) space o(m*n+l) where l is the length of the word.
 */
public class WordSearch {

	public WordSearch() {}

	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0 ) return false;
		int w =board[0].length;
		int h =board.length;

		for(int i=0; i<h; i++)
			for(int j=0; j<w; j++)
				if(helper(i,j,w,h,0,word,board)) return true;

		return false;
	}

	private boolean helper(int i, int j, int w, int h, int d, String word, char[][] board){  
		if(i<0 || i == h || j<0 || j == w || board[i][j] != word.charAt(d)) return false;

		if(d+1 == word.length()) return true;

		char cur = board[i][j];
		board[i][j] = 0;

		boolean res =  helper(i + 1, j, w, h, d+1, word, board) 
				|| helper(i - 1, j, w, h, d+1, word, board) 
				|| helper(i, j + 1, w, h, d+1, word, board)
				|| helper(i, j - 1, w, h, d+1, word, board);

		board[i][j] = cur;

		return res;
	}
}
