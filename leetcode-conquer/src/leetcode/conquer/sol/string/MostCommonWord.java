package leetcode.conquer.sol.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * first we parse the paragraph and remove all non-letter chars. and then wor count words in a hashmap
 * then load the counts + words into a priority queue and then return the max count from the priority queue
 * Time O(nlog(n))
 * space O(N)
 */
public class MostCommonWord {
	public MostCommonWord() {}

	public String mostCommonWord(String paragraph, String[] banned) {
		if(paragraph == null || paragraph.length() == 0) return paragraph;
		Set<String> ban = new HashSet<>(Arrays.asList(banned));
		char[] chs = paragraph.toCharArray();
		for(int i=0;i<chs.length;i++) if(!Character.isLetter(chs[i])) chs[i]=' ';
		paragraph = new String(chs);
		String[] words = paragraph.split(" ");
		Map<String,Integer> map = new HashMap<>();
		for(String word : words){
			if(word == null || word.isBlank() || ban.contains(word)) continue;
			map.put(word.toLowerCase(),map.getOrDefault(word.toLowerCase(),0)+1);
		}

		PriorityQueue<Data> q = new PriorityQueue<>((a,b)->(b.count-a.count));
		for(String key : map.keySet()){
			q.offer(new Data(key,map.get(key)));
		} 

		return q.poll().key;
	}

	class Data{
		String key;
		int count;

		public Data(String key, int count){
			this.key = key;
			this.count = count;
		}
	}
}
