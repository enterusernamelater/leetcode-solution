package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 126 bits trie with a hashset to store words. 
 * when search input we get the set and sort by the sentences below the trie branch 
 * and return the top 3 using heap
 * Time O(nlogn) because of the sort
 * Space O(N)
 */
class DesignSearchAutocompleteSystem {
	private Map<String,Integer> map = new HashMap<>();
	private StringBuilder sb = new StringBuilder();
	private Trie root = new Trie();

	public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
		for(int i=0;i<sentences.length;i++){
			map.put(sentences[i],times[i]);
			buildTrie(sentences[i],sentences[i],root);
		}
	}

	public String buildTrie(String oriStr,String str, Trie node){
		if(str.isEmpty()){
			node.isEnd = true;
			node.set.add(oriStr);
			return  oriStr;
		}

		String newString = buildTrie(oriStr,str.substring(1),node.get(str.charAt(0)));
		node.set.add(newString);
		return newString;
	}

	public List<String> input(char c) {
		if(c == '#'){
			map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
			buildTrie(sb.toString(),sb.toString(),root);
			sb = new StringBuilder();
			return new ArrayList<>();
		}

		sb.append(c);
		List<String> list = search(sb.toString(),root);

		PriorityQueue<Data> q = new PriorityQueue<>((a,b) -> (a.count == b.count? a.sentence.compareTo(b.sentence) : b.count-a.count));
		for(String key : list){
			q.offer(new Data(key,map.get(key)));
		}
		List<String> res = new ArrayList<>();
		while(!q.isEmpty() && res.size()<3){
			res.add(q.poll().sentence);
		}
		return res;
	}

	private List<String> search(String input, Trie node){
		for(int i=0;i<input.length();i++){
			node = node.trie[input.charAt(i)];
			if(node == null) return new ArrayList<>();
		}
		return new ArrayList<>(node.set);
	}

	class Data{
		String sentence;
		int count;
		public Data(String sentence, int count){
			this.sentence = sentence;
			this.count = count;
		}
	}

	class Trie{
		Trie[] trie = new Trie[126];
		Set<String> set = new HashSet<>();
		boolean isEnd = false;
		public Trie(){}

		public Trie get(int key){
			Trie node = this.trie[key];
			if(node == null) this.trie[key] = new Trie();
			return this.trie[key];
		}
	}
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
