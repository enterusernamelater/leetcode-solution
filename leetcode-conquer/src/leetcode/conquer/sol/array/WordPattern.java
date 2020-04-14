package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.Map;

/*
 * pattern match one word, one word match a pattern. if any condition fails return false;
 * Time O(n)
 * Space constant
 */
public class WordPattern {
	public WordPattern() {}
	
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> map1 = new HashMap<>();
        String[] words = str.split(" ");
        char[] p = pattern.toCharArray();
        if(words.length != p.length) return false;
        
        for(int i=0;i<p.length;i++){
            if(map.containsKey(p[i]) && !map.get(p[i]).equals(words[i])) return false;
            if(map1.containsKey(words[i]) && map1.get(words[i]) != p[i]) return false;
            map.put(p[i],words[i]);
            map1.put(words[i],p[i]);
        }
        return true;
    }
}
