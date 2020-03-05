package leetcode.conquer.sol.recursion.trie;

/*
 * same as the implement trie solution using list[26] but instead using a hashmap
 */
public class ImplementTrieHashMapSol {
	private TrieNodeHashMap root; 
	
	public ImplementTrieHashMapSol() {
		this.root = new TrieNodeHashMap();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		insertRecursive(root,word,0);
	}

	public void insertRecursive(TrieNodeHashMap root, String word, int i){
		if(i == word.length()){
			root.setEnd();
			return;
		}

		TrieNodeHashMap node = root.get(word.charAt(i));
		if(node == null) node = root.put(word.charAt(i), new TrieNodeHashMap());

		insertRecursive(node,word,++i);
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return helperSearch(root,word,0);
	}

	private boolean helperSearch(TrieNodeHashMap root, String word, int i){
		if(i == word.length() && root.isEnd()) return true;
		if(i == word.length()) return false;
		TrieNodeHashMap node = root.get(word.charAt(i));

		return node != null && helperSearch(node,word,++i);
	}


	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		return helper(root,prefix,0);
	}

	private boolean helper(TrieNodeHashMap root, String word, int i){
		if(i == word.length()) return true;
		TrieNodeHashMap node = root.get(word.charAt(i));

		return node != null && helper(node,word,++i);
	}   
}
