package leetcode.conquer.sol.recursion.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * very similar solution follow by the word search one solution
 * however we need to store all words into the Trie architecture for look up
 * time complexity will be o(w*h*4^wl) space o(m*n + wl)
 */
public class WordSearchII {
	public WordSearchII() {}
	
    private Set<String> res = new HashSet<>();
    private int w;
    private int h;
    
    public List<String> findWords(char[][] board, String[] words) {
        this.w = board[0].length;
        this.h = board.length;

        ImplementTrie trie = new ImplementTrie();
        
        for(String w : words)
            trie.insert(w);
        
        for(int i=0;i<h;i++)
            for(int j=0;j<w;j++)
                helper(i,j,trie,board,"");
        
        return new ArrayList<>(res);
    }
    
    private void helper(int i, int j, ImplementTrie trie, char[][] board, String str){
        if(i==h || i<0 || j==w || j<0 || board[i][j] =='$') return;
        
        str += board[i][j];
        if(!trie.startsWith(str)) return;
        
        if(trie.search(str)) res.add(str);
        /*
         * this is super important and I always forget about this
         * we backtracking through board make sure mark off the visiting ones 
         * so we dont end up stack overflow
         * also once visiting ones are done traversing return the original val back
         * to the board for the next traverse
         */
        char tmp = board[i][j];
        board[i][j]  = '$';
        helper(i+1,j,trie,board,str);
        helper(i-1,j,trie,board,str);
        helper(i,j+1,trie,board,str);
        helper(i,j-1,trie,board,str);
        board[i][j] = tmp;
    }
}
