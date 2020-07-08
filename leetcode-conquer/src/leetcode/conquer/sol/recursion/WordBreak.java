
package leetcode.conquer.sol.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * this solution is based on the link below
 * https://www.youtube.com/watch?v=ptlwluzeC1I
 * time n^2, space n
 */
public class WordBreak {
	public WordBreak() {}

	/*
	 * backtrack through the dict is much faster as traverse the string it self. as traverse the dict list is done 
	 * through a substring of s at a time. as for traverse the string s, in the solution two we traverse one char at a time which is super slow
	 * imagine a case like s=aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa and dict=aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa the first sol is a o(1) while the second solution is O(n)
	 * logic wish is very similar, we find the starting s substring that matches to the dict and then find the remaining substring see if matches the dict
	 * while doing the backtracking we store all the check substrings into a map. so the next time we encounter a same substring we can just return the result from the 
	 * map.
	 * 
	 */

	
	//dp solution
	public boolean wordBreakDp(String s, List<String> wordDict) {
		if(s.length() == 0 ^ wordDict.isEmpty()) return false;
		
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i=1; i<=s.length(); i++) {
			for(int j=0; j<wordDict.size() && !dp[i]; j++) {
				String word = wordDict.get(j);
				dp[i] = word.length() <= i && s.substring(i-word.length(),i).equals(word) && dp[i-word.length()];
			}
		}
		
		return dp[s.length()];
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
		if((s == null || s.length() == 0) ^ (wordDict == null || wordDict.size() == 0)) return false;
		return helper(s, wordDict, new HashMap<>());
	}

	private boolean helper(String s, List<String> wordDict, Map<String,Boolean> map){
		if(s == null || s.length() == 0) return true;
		if(map.containsKey(s)) return map.get(s);

		for(String word : wordDict){
			if(s.startsWith(word) && helper(s.substring(word.length(),s.length()), wordDict,map)){
				map.put(s,true);
				return true;
			}
		}

		map.put(s,false);
		return false;
	}

	//dp for solution two
	public boolean wordBreakSolTwoDP(String s, List<String> wordDict) {
		if(s.length() == 0 ^ wordDict.size() == 0) return false;
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		Set<String> dict = new HashSet<>(wordDict);
		for(int i=1;i<=s.length();i++) {
			for(int j=0; j<i && !dp[i]; j++) {
				String word = s.substring(j,i);
				dp[i] = dict.contains(word) && dp[j];
			}
		}
		return dp[s.length()];
	}
	HashMap<String, Boolean> map = new HashMap<>();
	public boolean wordBreakSolTwo(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>();
		for(String val : wordDict)
			set.add(val);
		return helperSolTwo(s,set);
	}

	private boolean helperSolTwo(String s, Set<String> dict){
		if(map.containsKey(s)) return map.get(s);

		if(dict.contains(s)) return true;

		for(int i=1;i<s.length();i++){
			String left = s.substring(0,i);
			String right = s.substring(i);

			if(dict.contains(right) && helperSolTwo(left,dict)){
				map.put(s,true);
				return true;
			}
		}

		map.put(s,false);
		return false;
	}
}
