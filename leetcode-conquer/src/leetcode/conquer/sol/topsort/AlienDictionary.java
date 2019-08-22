package leetcode.conquer.sol.topsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * The idea behind this solution is to find each pair of words first out and in different chars
 * once found and the in to the out key in the map if doesnt exists.
 * each time a new in is found, meaning the in is not from a duplicate out, we increment its inCount
 * 
 * After the map is implemented, we do a bfs top sort. starting by offer any outs no 'in' chars into the queue
 * and do the bfs style with the queue. 
 * if a in from the poll out doesnt after decrementing its inCount, its inCount is 0 this means we found a res char
 * we add to the sb. this process repeats untile the q is empty as in BFS
 * 
 * in the end the res string size should match all unqiue char size in the given words. if not we return empty string
 * link that explains this question:
 * https://www.youtube.com/watch?v=RIrTuf4DfPE
 * Time O(n) Space O(n)
 */
public class AlienDictionary {
	
	public AlienDictionary() {}
	
	public String alienOrder(String[] words) {
		if(words == null || words.length == 0) return "";
		int[] inCount = new int[26];
		Map<Character, Set<Character>> map = new HashMap<>();

		for(String str : words){
			for(char c : str.toCharArray()){
				map.putIfAbsent(c,new HashSet<>());
			}
		}

		int n = words.length;

		//build map for all in and out characters in the given words.
		for(int i=1;i<n;i++){
			String first = words[i-1];
			String second = words[i];
			int min = Math.min(first.length(),second.length());

			for(int j=0;j<min;j++){
				if(first.charAt(j) != second.charAt(j)){
					char out = first.charAt(j);
					char in = second.charAt(j);
					if(!map.get(out).contains(in)){
						map.get(out).add(in);
						inCount[in-'a']++;
					}

					break;
				}
			}
		}

		return topSortBfs(map,inCount);
	}

	private String topSortBfs(Map<Character,Set<Character>> map, int[] inCount){
		StringBuilder sb = new StringBuilder();
		Queue<Character> q = new LinkedList<>();

		//the final result size should equal to all unique char size
		int totalSize = map.size();

		for(char out : map.keySet()){
			if(inCount[out - 'a'] == 0){
				sb.append(out);
				q.offer(out);
			}
		}

		while(!q.isEmpty()){
			char out = q.poll();
			Set<Character> inSet = map.get(out);
			if(inSet == null || inSet.isEmpty()) continue;

			for(char in : inSet){
				inCount[in-'a']--;
				if(inCount[in-'a'] == 0){
					sb.append(in);
					q.offer(in);
				}
			}
		}

		return sb.length() == totalSize? sb.toString() : "";
	}
}
