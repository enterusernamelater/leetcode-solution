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
        Map<Character,Set<Character>> map = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(map,words,inDegree);
        return bfs(map,inDegree);
    }
    
    private String bfs(Map<Character,Set<Character>> map, int[] inDegree){
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        int total = map.size();
        for(Character c : map.keySet()){
            if(inDegree[c-'a'] == 0){
                q.offer(c); sb.append(c);
            }
        }
        
        while(!q.isEmpty()){
            char out = q.poll();
            Set<Character> set = map.get(out);
            if(set.isEmpty()) continue;
            
            for(char c : set){
                if(--inDegree[c-'a'] == 0){
                    q.offer(c); sb.append(c);
                }
            }
        }
        
        return sb.length() == total? sb.toString() : "";
    }
    
    private void buildGraph(Map<Character,Set<Character>> map, String[] words, int[] inDegree){
        for(String s : words){
            for(char c : s.toCharArray()) map.putIfAbsent(c,new HashSet<>());
        }
        
        for(int k=1;k<words.length;k++){
            char[] chs1 = words[k-1].toCharArray();
            char[] chs2 = words[k].toCharArray();
            for(int i=0,j=0;i<chs1.length && j<chs2.length;i++,j++){
               if(chs1[i] != chs2[j]){
                   if(map.get(chs1[i]).add(chs2[j])) inDegree[chs2[j]-'a']++;
                    break;   
               }
               //special case handle
               //the sort order expects that when all the letters between two words (first and second) match until one of the word is out of bound, the out of bound word should be the first not the second. 
               //(think about sort is ascending and shorter goes first)
               //so when this special case is detected, we clear the map and return the build graph so the bfs later will return empty string.
               if(i+1 < chs1.length && j+1==chs2.length){
                   map.clear();
                   return;
               } 
            }
        }
    }
}
