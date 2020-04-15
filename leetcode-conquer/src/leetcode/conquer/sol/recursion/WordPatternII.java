package leetcode.conquer.sol.recursion;

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

	/*
	 * This is my solution basically using the same approach from word pattern I when detecting word pattern matching
	 * backtracking solution finding out each substring mataches the current pattern, if is continue, if not backtrack
	 * with an additional backtracking starting point for handling special cases.
	 */
	private Map<Character,String> map1 = new HashMap<>();
	private Map<String,Character> map2 = new HashMap<>();
	private char[] p;
	public boolean wordPatternMatchMySol(String pattern, String str) {
		this.p = pattern.toCharArray();
		return helper(0,0,str);
	}

	private boolean helper(int pi, int si,String str){
		if(pi == p.length && si == str.length()) return true;
		if(pi == p.length) return false;
		if(si == str.length()) return false;
		/*
		 * this is a speical backtracking entry for handling a special case when a pattern has already been stored
		 * from the previous
		 * we need to reset the previous pattern if the current pattern fails
		 * try this as a special case: p: aa, str: aaaaa
		 * without this special backtracking entry point the above test case will return true
		 * but the answer is false because there is no pattern matching on above test cases.
		 */
		if(map1.containsKey(p[pi])){
			String word = map1.get(p[pi]);
			if(!str.startsWith(word,si)) return false;

			return helper(pi+1,si+word.length(),str);
		}
		for(int i=1;i<=str.length()-si;i++){
			String word = str.substring(si,si+i);

			if(map1.containsKey(p[pi]) && !map1.get(p[pi]).equals(word)) continue;
			if(map2.containsKey(word) && !map2.get(word).equals(p[pi])) continue;
			map1.putIfAbsent(p[pi],word);
			map2.putIfAbsent(word,p[pi]);
			if(helper(pi+1,si+i,str)) return true;

			map1.remove(p[pi]);
			map2.remove(word);
		}

		return false;
	}
}
