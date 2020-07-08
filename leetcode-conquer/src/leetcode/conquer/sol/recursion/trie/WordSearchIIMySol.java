package leetcode.conquer.sol.recursion.trie;

import java.util.ArrayList;
import java.util.List;

/*
 * basically adding the words to trie and find the word in trie using dfs
 * each dfs you cant go backwards so you will need a visited status
 * unlock visited once a node finished its dfs
 * once a word is found in trie mark the word to false. so you dont add a duplicate result
 * Time On(logm) m being the length of words
 * Space O(n)
 */
public class WordSearchIIMySol {
	
	public WordSearchIIMySol() {}
	
    public List<String> findWords(char[][] board, String[] words) {
        if(words == null || words.length == 0 || board.length == 0) return new ArrayList<>();
        
        Trie root = new Trie();
        for(String word : words){
            addWord(word,word,root);
        }
        
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(m,n,i,j,board,res,root, visited);
            }
        }
        
        return res;
    }
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    private void dfs(int m, int n, int i, int j, char[][] board, List<String> res, Trie root, boolean[][] visited){
        if(i<0||i==m||j<0||j==n|| !root.exists(board[i][j]) || visited[i][j]) return;
        Trie newNode = root.get(board[i][j]); visited[i][j] = true;
        if(newNode.isEnd){
            res.add(newNode.word);
            newNode.isEnd = false;
        }
        
        for(int[] val : dir){
            dfs(m,n,i+val[0],j+val[1],board,res,newNode,visited);
        }
        visited[i][j] = false;
    }
    
    private void addWord(String original, String word, Trie node){
        if(word.length() == 0){
            node.isEnd = true;
            node.word = original;
            return;
        }
        char c = word.charAt(0);
        Trie newNode = node.get(c) == null? node.add(c) : node.get(c);
        addWord(original,word.substring(1),newNode);
    }
    
    class Trie{
        Trie[] trie = new Trie[26];
        boolean isEnd = false;
        String word = "";
        
        public Trie(){}
        
        public Trie get(char c){
            return trie[c-'a'];
        }
        
        public boolean exists(char c){
            return trie[c-'a'] != null;
        }
        public Trie add(char c){
            this.trie[c-'a'] = new Trie();
            return this.trie[c-'a'];
        }
        public void remove(char c){
            this.trie[c-'a'] = null;
        }
    }
}
