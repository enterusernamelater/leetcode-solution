package leetcode.conquer.sol.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * split each string into substring 1 and 2 if one of them is palindrome, then check if the another substring's reverse exists in the
 * given words. if exists and is not the word itself we have found a pair.
 * Time O(n*k) k bean the length of the word
 * Space O(n)
 */
public class PalindromePairs {
	public PalindromePairs() {}

	public List<List<Integer>> palindromePairs(String[] words) {
		if(words == null || words.length == 0) return new ArrayList<>();
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<words.length;i++)
			map.put(words[i],i);

		List<List<Integer>> res = new ArrayList<>();
		for(int i=0;i<words.length;i++){
			String w = words[i];
			for(int j=0;j<=w.length();j++){
				String sub1 = w.substring(0,j);
				String sub2 = w.substring(j);

				if(isValid(sub1)){
					StringBuilder sb = new StringBuilder(sub2);
					String reversed = sb.reverse().toString();
					int index = map.getOrDefault(reversed,i);
					if(index != i) res.add(new ArrayList<>(Arrays.asList(index,i)));
				}

				//checking null because the full string of w is already checked in the first if sub1
				if(sub2.length() > 0 && isValid(sub2)){
					StringBuilder sb = new StringBuilder(sub1);
					String reversed = sb.reverse().toString();
					int index = map.getOrDefault(reversed,i);
					if(index != i) res.add(new ArrayList<>(Arrays.asList(i,index)));
				}
			}
		}

		return res;
	}

	private boolean isValid(String val){
		char[] arr = val.toCharArray();
		int i=0;
		int j=arr.length-1;

		while(i<j){
			if(arr[i++] != arr[j--]) return false;       
		}

		return true;
	}
}
