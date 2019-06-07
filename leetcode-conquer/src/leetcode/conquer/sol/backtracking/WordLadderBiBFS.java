package leetcode.conquer.sol.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * detailed explanation is in this link:
 * https://www.youtube.com/watch?v=vWPCm69MSfs
 * this is a bidirection bfs sol.. hard af
 * time o(n*26^(l/2)) n is the number of words in the dict l is the length of the word
 * space o(n)
 */
public class WordLadderBiBFS {
	public WordLadderBiBFS() {}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        
        if(!dict.contains(endWord)) return 0;
        
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        
        q1.add(beginWord);
        q2.add(endWord);
        
        int res = 0;
        while(!q1.isEmpty() && !q2.isEmpty()){
            res++;
            if(q1.size()>q2.size()){
                Set<String> tmp = q1;
                q1=q2;
                q2=tmp;
            }
            
            Set<String> q = new HashSet<>();
            
            for(String w : q1){
                char[] arr = w.toCharArray();
                for(int i=0;i<arr.length;i++){
                    char c = arr[i];
                    for(char j='a';j<='z';j++){
                        if(c == j) continue;
                        arr[i] = j;
                        String s = String.valueOf(arr);
                        //this is different from previous as we cannot check dict contains s before q2 because if q2 has the actual result its gonna be already removed from dict
                        //if order is switched here we will never find answer. 
                        if(q2.contains(s)) return res+1;
                        if(!dict.contains(s)) continue;
                        dict.remove(s);
                        q.add(s);
                    }
                    arr[i]=c;
                }
            }
            q1=q;
        }
        return 0;
    }
}
