package leetcode.conquer.sol.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/*
 * this question is followed by the link 
 * https://www.youtube.com/watch?v=JqOIRBC0_9c
 * need to understand both question 139 and 140
 * time o(2^n) because in the worst case we will need to find all combinations
 * space o(2^n)
 */
public class WordBreakII {
	Map<String,List<String>> map = new HashMap<>();
	
	public WordBreakII() {};
	 
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        
        return helper(s,set);
    }
    
    private List<String> helper(String s, Set<String> dict){
        if(map.containsKey(s)) return map.get(s);
        
        List<String> arr = new ArrayList<>();
        if(dict.contains(s)){
            arr.add(s);
        }

        for(int i=1;i<s.length();i++){
            String right = s.substring(i);
            if(!dict.contains(right)) continue;
            
            String left = s.substring(0,i);
            List<String> arrl = append(helper(left,dict),right);
            
            arr.addAll(arrl);
        }
        
        map.put(s,arr);
        return arr;
    }
    
    private List<String> append(List<String> arr, String str){
        List<String> res = new ArrayList<>();
        
        for(String s : arr){
            res.add(s+" "+str);
        }
        
        return res;
    }
}
