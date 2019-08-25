package leetcode.conquer.sol.String;

import java.util.HashMap;
import java.util.Map;

/*
 * use ASCII to get the min for each quries as well as for words
 * but use a map to store the result got for words to reduce look up time
 * Time O(n^2) Space O(n)
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
	public RemoveZeroSumConsecutiveNodesFromLinkedList() {}
	
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] res = new int[queries.length];
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<queries.length;i++){
			int qmin = getmin(queries[i]);
			int count = 0;
			for(String w : words){
				int wmin = map.getOrDefault(w,getmin(w));
				if(qmin<wmin) count++;
				map.putIfAbsent(w,wmin);
			}
			res[i] = count;
		}

		return res;
	}

	private int getmin(String str){
		int[] arr = new int[26];
		for(char c : str.toCharArray()){
			int i = (int)(c-'a');
			arr[i]++;
		}

		for(int i=0;i<26;i++){
			if(arr[i] != 0) return arr[i];
		}
		return Integer.MAX_VALUE;
	}
}
