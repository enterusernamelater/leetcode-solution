package leetcode.conquer.sol.backtracking;

/*
 * a dfs solution that first check all Os from the boarder and flip all the connected Os to #s
 * then go through the board again and turn the remaining Os to Xs
 * last we flipt back the turned #s into O.
 * time O(w*h), space o(w*h)
 */
public class SurroundedRegions {
	public SurroundedRegions() {}
	
	public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        
        int w = board[0].length;
        int h = board.length;
        
        //building #s on the first and last col.
        for(int i=0; i<h; i++){
            helper(i,0,w,h,board);
            helper(i,w-1,w,h,board);
        }
        
        //building #s on the first and last row.
        for(int j=0; j<w;j++){
            helper(0,j,w,h,board);
            helper(h-1,j,w,h,board);
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(i < 1 || i == h-1 || j < 1 || j == w-1) continue;
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(board[i][j] =='#') board[i][j] = 'O';
            }
        }
    }
    
    private void helper(int i, int j, int w, int h, char[][] board){
        if(i<0 || i==h || j<0 || j==w || board[i][j]=='X' || board[i][j] == '#') return;
        
        if(board[i][j] == 'O') board[i][j] ='#';
        helper(i+1,j,w,h,board);
        helper(i-1,j,w,h,board);
        helper(i,j+1,w,h,board);
        helper(i,j-1,w,h,board);
    }

}
