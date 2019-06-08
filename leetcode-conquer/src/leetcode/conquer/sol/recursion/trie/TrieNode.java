package leetcode.conquer.sol.recursion.trie;

/*
 * time and pace constant
 * check the solution in the following link:
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class TrieNode {
	private TrieNode[] links;
	private final int size = 26;
	private boolean isEnd;

	public TrieNode(){
		links = new TrieNode[size];
	}

	public boolean containsKey(char c){
		return links[c-'a'] != null;
	}

	public TrieNode get(char c){
		return links[c-'a'];
	}
	
	public TrieNode getIndex(int i){
		return links[i];
	}

	public void put(char c, TrieNode node){
		links[c-'a'] = node;
	}

	public void setEnd(){
		this.isEnd = true;
	}

	public boolean isEnd(){
		return this.isEnd;
	}
}
