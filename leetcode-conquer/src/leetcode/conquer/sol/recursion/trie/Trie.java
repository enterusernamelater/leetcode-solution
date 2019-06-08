package leetcode.conquer.sol.recursion.trie;

/*
 * a self wrote recursive Trie 
 * time will be depend on the length of the words
 * o(n)
 * space grows as the words length
 * o(n)
 * 
 * the complexity here is for the worst case which is the insertion
 * however when comes to search and search prefix the time is o(n)
 * and the space is o(1)
 */
public class Trie {
	private TrieNode root;
	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		insertRecursive(word,node);
	}

	private void insertRecursive(String word, TrieNode node){
		if(word == null || word.length() == 0) {
			node.setEnd();
			return;
		}
		if(!node.containsKey(word.charAt(0)))
			node.put(word.charAt(0), new TrieNode());

		insertRecursive(word.substring(1),node.get(word.charAt(0)));
	}
	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = root;
		return searchRecursive(word,node);
	}

	private boolean searchRecursive(String word, TrieNode node){
		if(node.isEnd() && (word == null || word.length() == 0)) return true;
		if(word == null || word.length() == 0) return false;

		return node.containsKey(word.charAt(0)) && searchRecursive(word.substring(1), node.get(word.charAt(0)));
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		return startsWithRecursive(prefix,node);
	}

	private boolean startsWithRecursive(String prefix, TrieNode node){
		if(prefix == null || prefix.length() == 0) return true;

		return node.containsKey(prefix.charAt(0)) && startsWithRecursive(prefix.substring(1), node.get(prefix.charAt(0)));
	}
}
