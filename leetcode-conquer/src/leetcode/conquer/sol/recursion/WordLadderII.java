package leetcode.conquer.sol.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/*
 * this solution has a similar approach to the WordLadder 1 sol. however the tricky part is find a way to store the results
 * we need to do this by using a dfs search.
 * an detailed solution can be found in the following link:
 * https://www.youtube.com/watch?v=PblfQrdWXQ4
 * Time O(n*26^l) n is the length of the wordList is the l is length of the word.
 * space o(n + s*p) where s is the result size and p is each resule's list length.
 */
public class WordLadderII {

	public WordLadderII() {}

	private List<List<String>> res = new ArrayList<>();
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if(wordList == null || wordList.size() ==0) return res;

		Set<String> dict = new HashSet<>(wordList);

		if(!dict.contains(endWord)) return res;

		dict.remove(endWord);
		dict.remove(beginWord);

		Map<String, Integer> mapStep = new HashMap<>();
		Map<String, List<String>> mapParent = new HashMap<>();

		mapStep.put(beginWord,1);

		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);

		int step = 0;

		boolean found = false;
		while(!q.isEmpty() && !found){
			int size = q.size();
			step++;

			for(int i=0;i<size;i++){
				String word = q.poll();
				char[] arr = word.toCharArray();
				for(int j=0;j<arr.length;j++){
					char c = arr[j];
					for(char k='a'; k<='z'; k++){
						if(k == c) continue;
						arr[j] = k;
						String newWord = String.valueOf(arr);

						List<String> parents = mapParent.getOrDefault(newWord, new ArrayList<>());

						if(newWord.equals(endWord)){
							parents.add(word);
							mapParent.put(newWord,parents);
							found=true;
							//mapStep.get(newWord) > step this ensures that we only add parents of the new word with in the same level of the bfs traverse
						}else if(mapStep.containsKey(newWord) && mapStep.get(newWord) > step){
							parents.add(word);
							mapParent.put(newWord, parents);
						}

						if(!dict.contains(newWord)) continue;
						dict.remove(newWord);

						parents.add(word);
						mapParent.put(newWord,parents);
						mapStep.put(newWord,mapStep.get(word)+1);
						q.offer(newWord);
					}
					arr[j] = c;
				}
			}
		}

		if(mapParent.containsKey(endWord)){
			Deque<String> stack = new ArrayDeque<>();
			stack.push(endWord);
			helper(mapParent,endWord,beginWord,stack);
		}

		return res;
	}

	private void helper(Map<String, List<String>> map, String end, String start, Deque<String> stack){
		if(start.equals(end)){
			res.add(new ArrayList<>(stack));
			return;
		}

		for(String str : map.get(end)){
			stack.push(str);
			helper(map,str,start,stack);
			stack.pop();
		}
	}
}
