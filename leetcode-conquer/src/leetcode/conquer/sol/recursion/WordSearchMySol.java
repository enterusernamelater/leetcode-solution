package leetcode.conquer.sol.recursion;

/*
 * pretty much the same as the original solution I did before in word search just a bit of the different code styling 
 * and used a used matrix
 */
public class WordSearchMySol {
	public WordSearchMySol() {}
	
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        
         for(int i=0;i<board.length;i++){
             for(int j=0;j<board[0].length;j++){
                 if(helper(i,j,0,word,board,used)) return true;
             }
         }
        
        return false;
    }
    
    private boolean helper(int i, int j, int index, String word, char[][] board, boolean[][] used){
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || used[i][j] || board[i][j] != word.charAt(index)) return false;
    
        used[i][j] = true;
        index = index + 1;
        
        if(index == word.length()){
            return true;
        } 
        
        if(helper(i+1,j,index,word,board,used)) return true;
        if(helper(i-1,j,index,word,board,used)) return true;
        if(helper(i,j+1,index,word,board,used)) return true;
        if(helper(i,j-1,index,word,board,used)) return true;
        
        return used[i][j]=false;
    }
}
