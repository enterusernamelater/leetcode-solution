package leetcode.conquer.sol.queue.priority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Priority Queue with sorting properties
 * Time O(nlog(n))
 * Space constant
 */
public class TopKFrequentWords {
	public TopKFrequentWords() {}
	
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Data> q = new PriorityQueue<>((a,b) -> (a.count == b.count? a.word.compareTo(b.word) : b.count - a.count));
        for(String word : words) map.put(word, map.getOrDefault(word,0)+1);
        
        for(String key : map.keySet()){
            q.offer(new Data(key,map.get(key)));
        }
        
        List<String> res = new ArrayList<>();
        while(!q.isEmpty() && k > 0){
            res.add(q.poll().word);
            k--;
        }
        
        return res;
    }
    
    class Data{
        public String word;
        public int count = 0;
        
        public Data(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}
