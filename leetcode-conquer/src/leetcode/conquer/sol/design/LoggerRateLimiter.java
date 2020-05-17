package leetcode.conquer.sol.design;

import java.util.HashMap;
import java.util.Map;

/*
 * This solution is pretty self explanatory 
 * Update hashmap if time passed other was return false
 * when a new record comes in add time stamp into hashmap and return true;
 */
public class LoggerRateLimiter {
    private Map<String,Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        this.map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int time = map.getOrDefault(message, timestamp - 11);
        
        if(timestamp - time < 10) return false;
        
        map.put(message,timestamp);
        return true;
    }
}
