package leetcode.conquer.sol.recursion.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNodeHashMap {
	private Map<Character,TrieNodeHashMap> map = new HashMap<>();
	private boolean isEnd = false;

	public TrieNodeHashMap(){}

	public boolean contains(char c){
		return map.containsKey(c);
	}

	public TrieNodeHashMap get(char c){
		return map.get(c);
	}

	public TrieNodeHashMap put(char c, TrieNodeHashMap node){
		map.put(c,node);
		return node;
	}

	public boolean isEnd(){
		return this.isEnd;
	}

	public void setEnd(){
		this.isEnd = true;
	}
}
