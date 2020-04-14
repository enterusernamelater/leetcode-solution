package leetcode.conquer.sol.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * using a map with a hash set to fit following purposes:
 * in order for the word to be unique one of the following condition needs to match
 * 1. the word abbreviation is not in the given dict
 * 2. if the word abbreviation is in the given dict, the word has to be the only one in the dict that produces the matching
 * word abbreviation 
 * Time O(n)
 * Space O(n)
 */
public class UniqueWordAbbreviation {
	public UniqueWordAbbreviation() {}
	
	private Map<String,Set<String>> map = new HashMap<>();
    public UniqueWordAbbreviation(String[] dict) {
        for(String word : dict){
            int val = word.length() - 2;
            if(val > 0){
                String key = new StringBuilder().append(word.charAt(0)).append(val).append(word.charAt(word.length()-1)).toString();
                Set<String> set = map.getOrDefault(key, new HashSet<>());
                set.add(word);
                map.putIfAbsent(key,set);
            }
        }
    }
    
    public boolean isUnique(String word) {
        if(word.length()<3) return true;
        int val = word.length()-2;
        String key = new StringBuilder().append(word.charAt(0)).append(val).append(word.charAt(word.length()-1)).toString();
        if(!map.containsKey(key)) return true;
        Set<String> set = map.get(key);
        if(set.contains(word) && set.size() == 1) return true;
        
        return false;
    }
}
