package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * pretty simple soltuion using hashmap stores the words indexes
 * and bruteforce finding the shortest distance between two words' indexes
 * Time worst O(n^2)
 * Space O(n)
 */
public class ShortestWordDistanceII {
    private Map<String,List<Integer>> map = new HashMap<>();
    
    public ShortestWordDistanceII(String[] words) {
        for(int i=0;i<words.length;i++){
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.putIfAbsent(words[i],list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        
        for(int val1 : list1)
            for(int val2 : list2)
                res = Math.min(Math.abs(val1-val2),res);
        
        return res;
    }
}
