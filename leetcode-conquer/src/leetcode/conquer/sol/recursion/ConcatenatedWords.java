package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * dfs + memorization basically a word search II solution
 */
public class ConcatenatedWords {
	public ConcatenatedWords() {}
	
    private List<String> res = new ArrayList<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words == null || words.length == 0) return new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> cache = new HashMap<>();
        
        for(String word : words){
            dfs(word,set,cache);
            if(cache.get(word) != null && cache.get(word)) res.add(word);
        }
        
        return res;
    }
    
    private Boolean dfs(String word, Set<String> set, Map<String,Boolean> cache){
        if(cache.get(word) != null) return cache.get(word);
        
        for(int i=1;i<=word.length();i++){
            if(set.contains(word.substring(0,i))){
                String subWord = word.substring(i);
                //when empty we know this is a dictionary word not concatenation.
                if(subWord.isEmpty()){
                    return true;
                }else if(dfs(word.substring(i),set,cache)){
                    cache.put(word,true);   
                    return true;
                }
            }
        }
        
        if(cache.get(word) == null) cache.put(word,false);
        return cache.get(word);
    }
}
