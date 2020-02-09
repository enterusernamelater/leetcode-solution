package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * contest question add and sort the result when get
 * increment the index if the current index val is less that the interval
 * Time O(nlogn)
 * Space O(n)
 */
public class TweetCountsPerFrequency {
    private Map<String,Integer> feqs = new HashMap<String,Integer>(){
		private static final long serialVersionUID = 4425424236998851844L;
	{
        put("day",86400);
        put("hour",3600);
        put("minute",60);
    }};
    
    private Map<String,List<Integer>> map;
    public TweetCountsPerFrequency() {
        this.map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        List<Integer> list = map.getOrDefault(tweetName,new ArrayList<>());
        list.add(time);
        map.putIfAbsent(tweetName,list);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> times = map.get(tweetName);
        if(times == null) return new ArrayList<>();
        Collections.sort(times);
        Integer val = feqs.get(freq);
        
        List<Integer> res = new ArrayList<>();
        
        int start = startTime;
        int end = Math.min(startTime+val,endTime+1);
        int count = 0;
        int i = 0;
        
        while(end <=endTime+1){
            while(i<times.size() && times.get(i)<start)i++;
            while(i<times.size() && times.get(i)>= start && times.get(i)<end){
                i++;
                count++;
            }
            
            res.add(count);
            count = 0;
            
            if(end == endTime+1) break;
            start = end;
            end = Math.min(start+val,endTime+1);
        }
        
        return res;
    }
}
