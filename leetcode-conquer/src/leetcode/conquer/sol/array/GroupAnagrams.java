package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * first solution creates hashcode on each string's ascii arr and do a get on a map
 * second solution sorts the string and do get on a map
 * 
 * first solution Time O(n*m) space O(n*m)
 * 
 * second solution Time O(n*mlog(m)), space O(n*m) 
 */
public class GroupAnagrams {
	private Map<Integer, List<String>> map1 = new HashMap<>();
	
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
		
		for(String s : strs){
			int key = getHashCode(s.toCharArray());
			
			List<String> list = map1.getOrDefault(key, new ArrayList<>());
			list.add(s);
			map1.putIfAbsent(key,list);
		}
		
		return new ArrayList<>(map1.values());
    }
    
    private int getHashCode(char[] arr){
        int[] hash = new int[26];
        for(int i=0;i<arr.length;i++)
            hash[arr[i] - 'a']++;
        
        return Arrays.hashCode(hash);
    }
    
    private Map<String, List<String>> map2 = new HashMap<>();
    public List<List<String>> groupAnagramsSolTwo(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
		
		for(String s : strs){
			char[] arr = s.toCharArray();
            Arrays.sort(arr);
			String key = new String(arr);
			List<String> list = map2.getOrDefault(key, new ArrayList<>());
			list.add(s);
			map2.putIfAbsent(key,list);
		}
		
		return new ArrayList<>(map2.values());
    }
}
