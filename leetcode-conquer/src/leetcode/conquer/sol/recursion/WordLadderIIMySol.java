package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * a bit code clean up compare to the ori solution and used linkedlist to populate the result instead of using stack
 */
public class WordLadderIIMySol {
	public WordLadderIIMySol() {}

	public List<List<String>> findLadders(String start, String end, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		if(!dict.contains(end)) return new ArrayList<>();

		dict.remove(start);
		dict.remove(end);

		Map<String, List<String>> mapParent = new HashMap<>();
		Map<String, Integer> mapStep = new HashMap<>();
		mapStep.put(start,1);

		Queue<String> q = new LinkedList<>();
		q.offer(start);

		int level = 0, found = 0;
		while(!q.isEmpty() && found == 0){
			int size = q.size();
			level++;
			for(int i=0;i<size;i++){
				String word = q.poll();
				char[] arrc = word.toCharArray();
				for(int j=0; j<arrc.length; j++){
					char save = arrc[j];
					for(char k='a'; k<='z'; k++){
						if(arrc[j] == k) continue;
						arrc[j] = k;
						String nword = new String(arrc);

						List<String> list = mapParent.getOrDefault(nword, new ArrayList<>());

						if(dict.contains(nword) || end.equals(nword) || (mapStep.containsKey(nword) && mapStep.get(nword) - level == 1)){
							list.add(word);
							mapParent.put(nword,list);

							if(end.equals(nword)) found=1;
						}

						if(!dict.contains(nword)) continue;

						mapStep.put(nword, mapStep.get(word)+1);
						dict.remove(nword);
						q.offer(nword);
					}
					arrc[j] = save;
				}
			}
		}

		List<List<String>> res = new ArrayList<>();
		dfs(mapParent,start,end,res,new LinkedList<>(Arrays.asList(end)));
		return res;
	}

	private void dfs(Map<String, List<String>> map, String start, String end, List<List<String>> res, LinkedList<String> list){    
		if(start.equals(end)){
			res.add(new ArrayList<>(list));
			return;
		}

		if(!map.containsKey(end)) return;

		for(String s : map.get(end)){
			list.addFirst(s);
			dfs(map,start,s,res,list);
			list.removeFirst();   
		}
	}
}
