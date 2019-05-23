package leetcode.conquer.sol.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * this solution is based on the link below
 * https://www.youtube.com/watch?v=ptlwluzeC1I
 * time n^2, space n
 */
public class WordBreak {
	public WordBreak() {}
	
	 HashMap<String, Boolean> map = new HashMap<>();
	    public boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> set = new HashSet<>();
	        for(String val : wordDict)
	            set.add(val);
	        return helper(s,set);
	    }
	    
	    private boolean helper(String s, Set<String> dict){
	        if(map.containsKey(s)) return map.get(s);
	        
	        if(dict.contains(s)) return true;
	        
	        for(int i=1;i<s.length();i++){
	            String left = s.substring(0,i);
	            String right = s.substring(i);
	      
	            if(dict.contains(right) && helper(left,dict)){
	                map.put(s,true);
	                return true;
	            }
	        }
	        
	        map.put(s,false);
	        return false;
	    }
}
