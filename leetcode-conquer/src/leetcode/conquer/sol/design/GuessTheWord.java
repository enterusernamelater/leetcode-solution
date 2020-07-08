package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * map each string and find each strings non match to other count
 * loop through the map find the string has min non match to other string
 * guess on that string and remove all string that dont have the match to this gussed string
 * above loop continues until the word is found or return nothing.
 * https://www.youtube.com/watch?v=7RLSjgBiNOo
 */
public class GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = Arrays.asList(wordlist);
        while(!list.isEmpty()){
            //first finding all words dont match to other 
            Map<String,Integer> map = new HashMap<>();//zeroMatches;
            for(String w1 : list){
                for(String w2 : list){
                    int count = compare(w1,w2);
                    if(count == 0){
                        map.put(w1, map.getOrDefault(w1,0)+1);
                    }
                }
            }
            
            //take out the min of dont match to other words word.
            int min = Integer.MAX_VALUE;
            String guessWord = list.get(0);
            for(String key : map.keySet()){
                if(map.get(key) < min){
                    min = map.get(key);
                    guessWord = key;
                }
            }
            
            int matches = master.guess(guessWord);
            List<String> tmp = new ArrayList<>();
            if(matches == 6) return;
            
            //remove all words in the map that dont have the 'matches' to the guessWord;
            for(String w : list){
                if(matches == compare(w,guessWord)){
                    tmp.add(w);
                }
            }
            list = tmp;    
        }
    }
    
    private int compare(String w1, String w2){
        int count = 0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i) == w2.charAt(i)){
                count++;
            }
        }
        return count;
    }
    
    class Master{
    	public int guess(String str) {
    		return 0;
    	}
    }
}
