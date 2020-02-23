package leetcode.conquer.sol.recursion;

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
	
	/*
	 * my own solution, same as the word break i, but we rememeber each sub s's word break and break them all the 
	 * way to the top and add them up to form our final result
	 */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        helper(s,wordDict,map, "");
        return map.get(s);
    }
    
    private List<String> helper(String s, List<String> wordDict, Map<String,List<String>> map, String curr){
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        if(map.containsKey(s)) return map.get(s);
        
        List<String> list = new ArrayList<>();
        for(String word : wordDict){
            if(s.startsWith(word)){
                String right = s.substring(word.length(),s.length());
                List<String> vals = helper(right, wordDict, map, word);
            
                if(!right.isEmpty() && vals.isEmpty()) continue;
            
                //to handle a special case when the current substring s can be formed by one word in the dict so the right is empty
                //in that case we add the whole word from the dict to the map that maps the current substring s to an arr of words that
                //forms s from the dict.
                if(right.isEmpty()) list.add(word);
                //during the special case mentioned above, vals will be empty as the right substring will be empty. recursion returns empty array
                for(String str : vals){
                    list.add(word + " " + str);
                }
            }
        }
        
        map.put(s, list);
        return map.get(s);
    }
    
	Map<String,List<String>> map = new HashMap<>();
	
	public WordBreakII() {};
	 
    public List<String> wordBreakSolTwo(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        
        return helperSolTwo(s,set);
    }
    
    private List<String> helperSolTwo(String s, Set<String> dict){
        if(map.containsKey(s)) return map.get(s);
        
        List<String> arr = new ArrayList<>();
        if(dict.contains(s)){
            arr.add(s);
        }

        for(int i=1;i<s.length();i++){
            String right = s.substring(i);
            if(!dict.contains(right)) continue;
            
            String left = s.substring(0,i);
            List<String> arrl = append(helperSolTwo(left,dict),right);
            
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
