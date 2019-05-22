package leetcode.conquer.sol.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * This solution is followed by this link: 
 * https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution
 * time complexity O(pattern.length C s.length), space complexity is O(n)
 */
public class WordPatternII {
	public WordPatternII() {}

	Map<Character, String> map = new HashMap<>();
	Set<String> set = new HashSet<>();
	public boolean wordPatternMatch(String p, String s) {
		return helper(p,s,0,0);
	}

	private boolean helper(String p, String s, int startP, int startS){
		if(startP == p.length() && startS == s.length()) return true;
		if(startP == p.length() || startS == s.length()) return false;

		char c = p.charAt(startP);
		if(map.containsKey(c)){
			String val = map.get(c);

			if(!s.startsWith(val,startS)) return false;

			return helper(p, s, startP+1, startS+val.length());
		}

		//backtracking
		for(int i = startS; i<s.length();i++){
			String subStr = s.substring(startS,i+1);
			if(set.contains(subStr)) continue;

			map.put(c,subStr);
			set.add(subStr);

			if(helper(p,s,startP+1,i+1)) return true;

			map.remove(c);
			set.remove(subStr);
		}

		return false;
	}
}
