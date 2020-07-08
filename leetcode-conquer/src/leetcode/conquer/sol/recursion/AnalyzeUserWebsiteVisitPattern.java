package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * first we store each user's visited site and time into a hashmap
 * then we store each users visited site in combo of 3 (sorted by the timestamp, basically finding all combination of 3 also use a set to make sure not adding the same combo key count twice)
 * to a map with the combo as the key and number of users as the count
 * in the end we return the most visited combo by sorting the map after adding to the list.
 * Close to Time O(nlog(n)) but depending on the combination
 * Space O(N) 
 */
public class AnalyzeUserWebsiteVisitPattern {
	public AnalyzeUserWebsiteVisitPattern() {}
	
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String,List<Data>> map = new HashMap<>();
        for(int i=0;i<username.length;i++){
            List<Data> list = map.getOrDefault(username[i],new ArrayList<>());
            list.add(new Data(website[i],timestamp[i]));
            map.putIfAbsent(username[i],list);
        }
        Map<String,Integer> userMap = new HashMap<>();
        for(String key : map.keySet()){
            if(map.get(key).size()<3) continue;
            List<Data> list = map.get(key);
            Collections.sort(list,(a,b) -> (a.count-b.count));
            addCombo(userMap,key,list,"",0,0, new HashSet<>());
        }
        
        List<Data> resList = new ArrayList<>();
        for(String key : userMap.keySet()){
            resList.add(new Data(key,userMap.get(key)));
        }
        
        Collections.sort(resList,(a,b) -> (a.count == b.count? a.combo.compareTo(b.combo) : b.count-a.count));
        
        return new ArrayList<>(Arrays.asList(resList.get(0).combo.split(" ")));
    }
    
    private void addCombo(Map<String,Integer> map, String user, List<Data> list, String key, int size, int index, Set<String> record){
        if(size == 3){
            String str = key.trim();
            if(record.add(str)) map.put(str,map.getOrDefault(str,0)+1);
            return;
        }
        if(size > 3) return;
        
        for(int i=index;i<list.size();i++){
            addCombo(map,user,list,key+list.get(i).combo+" ",size+1,i+1,record);
        }
    }
    
    class Data{
        public String combo;
        public int count;
        
        public Data(String combo, int count){
            this.combo = combo;
            this.count = count;
        }
    }
}
