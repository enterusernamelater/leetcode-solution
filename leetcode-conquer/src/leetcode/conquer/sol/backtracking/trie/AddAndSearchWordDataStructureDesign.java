package leetcode.conquer.sol.backtracking.trie;

/*
 * similar solution to trie sol but when the char is . 
 * we need to use backtracking to visit every existing node in trie 
 * in order to find the word 
 * n is the length of the word, m is the total length of the words in trie.
 * time o(n) for add, o(m) for search
 * space o(m)
 */
public class AddAndSearchWordDataStructureDesign {
	
	public AddAndSearchWordDataStructureDesign() {}
	
	class WordDictionary {
	    private TrieNode root;
	    private final int size = 26;
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        TrieNode node = root;
	        for(char c : word.toCharArray()){
	            if(!node.containsKey(c)) node.put(c,new TrieNode());
	            node = node.get(c);
	        }
	        node.setEnd();
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        TrieNode node = root;
	        return searchRecursive(word, node);
	    }
	    
	    public boolean searchRecursive(String word, TrieNode node){
	        if((word == null || word.length() == 0) && node.isEnd()) return true;
	        if(word == null || word.length() == 0) return false;
	        
	        if(word.charAt(0) == '.'){
	            for(int i=0;i<size;i++){
	                if(node.getIndex(i) == null) continue;
	                TrieNode cur = node.getIndex(i);
	                if(searchRecursive(word.substring(1),cur)) return true;
	            }
	        }
	        return word.charAt(0) != '.' &&node.containsKey(word.charAt(0)) && searchRecursive(word.substring(1), node.get(word.charAt(0)));
	    }
	}
}
