package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmazonAO
{        
	public List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
		Collections.sort(logLines, (log1, log2) -> {
			String[] split1 = log1.split(" ", 2);
			String[] split2 = log2.split(" ", 2);
			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
			if (!isDigit1 && !isDigit2) {
				int cmp = split1[1].compareTo(split2[1]);
				if (cmp != 0) return cmp;
				return split1[0].compareTo(split2[0]);
			}
			return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
		});
		return logLines;
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<String> retrieveMostFrequentlyUsedWords(String helpText, List<String> wordsToExclude)
	{
		if(helpText == null || helpText.length() == 0) return new ArrayList<>();
		Set<String> dict = new HashSet<>(wordsToExclude);
		Map<String,Integer> map = new HashMap<>();

		char[] chs = helpText.trim().toCharArray();
		for(int i=0;i<chs.length;i++) {
			if(!Character.isLetter(chs[i])) chs[i] =' ';
		}
		helpText = new String(chs);
		
		String[] arr = helpText.split(" ");
		for(String s : arr){
			if(dict.contains(s)) continue;
			if(s == null || s.length() ==0) continue;
			String word = s.toLowerCase();
			map.put(word,map.getOrDefault(word,0)+1);
		}

		PriorityQueue<Data> q = new PriorityQueue<>((a,b) -> (b.count - a.count));
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			q.offer(new Data(entry.getKey(),entry.getValue()));
		}
		
		List<String> res = new ArrayList<>();
		if(q.isEmpty()) return res;

		Data data = q.poll();
		int max = data.count;
		while(!q.isEmpty() && data.count == max){
			res.add(data.s);
			data = q.poll();
		}
		
		return res;
	}

	class Data{
		public String s;
		public int count;

		public Data(String s, int count) {
			this.s=s;
			this.count = count;
		}
	}
	// METHOD SIGNATURE ENDS
}