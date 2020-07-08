package leetcode.conquer.sol.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/*
 * this solution has a similar approach to the WordLadder 1 sol. however the tricky part is find a way to store the results
 * we need to do this by using a dfs search.
 * an detailed solution can be found in the following link:
 * https://www.youtube.com/watch?v=PblfQrdWXQ4
 * Time O(n*26^l) n is the length of the wordList is the l is length of the word.
 * space o(n + s*p) where s is the result size and p is each resule's list length.
 */
public class WordLadderII {

	public WordLadderII() {}

    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0) return new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        Map<String,List<String>> graph = new HashMap<>();
        Map<String,Integer> levels = new HashMap<>();
        levels.put(beginWord,1);
        int step = 0;
        
        while(!q.isEmpty() && !q.peek().equals(endWord)){
            step++;
            for(int k=q.size();k>0;k--){
                String child = q.poll();
                char[] chs = child.toCharArray();
                
                for(int i=0;i<chs.length;i++){
                    char ori = chs[i];
                    for(char j='a'; j<='z' ;j++){
                        if(j==ori) continue;
                        chs[i] = j;
                        String parent = new String(chs);
                        List<String> list = graph.getOrDefault(parent,new ArrayList<>());
                        //sometimes a child can genreate a duplicate parent that exists in the graph
                        if(graph.containsKey(parent) && levels.get(parent) > step){
                            list.add(child);
                        }
                        
                        if(!dict.contains(parent)) continue;
                        dict.remove(parent);
                        q.offer(parent);
                        list.add(child);
                        graph.put(parent,list);
                        levels.put(parent,levels.get(child)+1);
                    }
                    chs[i] = ori;
                }
            }
        }
        
        if(!graph.containsKey(endWord)) return res;
        dfs(graph, beginWord, endWord, new ArrayDeque<>(Arrays.asList(endWord)));
        return res;
    }
    
    private void dfs( Map<String,List<String>> graph, String beginWord, String endWord, Deque<String> stack){
        if(endWord.equals(beginWord)){
            res.add(new ArrayList<>(stack));
            return;
        }
        
        for(String word : graph.get(endWord)){
            stack.push(word);
            dfs(graph,beginWord,word,stack);
            stack.pop();
        }
    }
}
