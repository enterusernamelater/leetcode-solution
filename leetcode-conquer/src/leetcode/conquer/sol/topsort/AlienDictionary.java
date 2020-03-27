package leetcode.conquer.sol.topsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * The idea behind this solution is to find each pair of words first out and in different chars
 * once found and the in to the out key in the map if doesn't exists.
 * each time a new in is found, meaning the in is not from a duplicate out, we increment its inCount
 * 
 * After the map is implemented, we do a bfs top sort. starting by offer any outs no 'in' chars into the queue
 * and do the bfs style with the queue. 
 * if a in from the poll out after decrementing its inCount, its inCount is 0 this means we found a res char
 * we add to the sb. this process repeats until the q is empty as in BFS
 * 
 * in the end the res string size should match all unqiue char size in the given words. if not we return empty string
 * 
 * a special case needs to handle: ["abc","ab"]
 * see comment below on handling this spedial case
 * 
 * link that explains this question:
 * https://www.youtube.com/watch?v=LA0X_N-dEsg
 * Time O(n) Space O(n)
 */
public class AlienDictionary {
	
	public AlienDictionary() {}
	
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(map,inDegree,words);
        return bfs(map, inDegree);
    }
    
    private String bfs(Map<Character,Set<Character>> map, int[] inDegree){        
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : map.keySet()){
            if(inDegree[c-'a'] == 0){
                q.offer(c); sb.append(c);
            }
        }
        
        while(!q.isEmpty()){
            char cur = q.poll();
            if(map.get(cur).isEmpty()) continue;
            
            for(char c : map.get(cur)){
                if(--inDegree[c-'a']>0) continue;
                q.offer(c); sb.append(c);
            }
        }
        
        return sb.toString().length() == map.size()? sb.toString() : "";
    }
    
    private void buildGraph(Map<Character,Set<Character>> map, int[] inDegree, String[] words){
        for(String s : words)
            for(char c : s.toCharArray())
                map.putIfAbsent(c,new HashSet<>());
        
        for(int i=1;i<words.length;i++){
            char[] first = words[i-1].toCharArray();
            char[] second = words[i].toCharArray();
            int len = Math.min(first.length,second.length);
            for(int j=0;j<len;j++){
                if(first[j] != second[j]){
                    if(map.get(first[j]).add(second[j])) inDegree[second[j] - 'a']++;
                    break;
                }
                
                //special case handle
                //the sort order expects that when all the letters between two words (first and second) match until one of the word is out of bound, the out of bound word should be the first not the second. 
                //(think about sort is ascending and shorter goes first)
                //so when this special case is detected, we clear the map and return the build graph so the bfs later will return empty string.
                if(j+1 == len && first.length > second.length){
                    map.clear();
                    return;
                }   
            }
        }
    }
}
