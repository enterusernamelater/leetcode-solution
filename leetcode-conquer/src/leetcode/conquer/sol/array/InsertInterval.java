package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.List;

/*
 * super interesting solution, my explanation attached below
 * Time O(n)
 * Space O(n)
 */
public class InsertInterval {
	public InsertInterval() {}
	
    public int[][] insert(int[][] intervals, int[] newInterval) {        
        List<int[]> res = new ArrayList<>();
        
        //add all the ones thats before the newInterval, where interval'end is smaller than new interval's start
        int i=0;
        while(i<intervals.length && intervals[i][1] < newInterval[0])
            res.add(intervals[i++]);
        
        //since we now know the rest has their end greater than new interval's start then only invalid case here
        //is when their start is greater than the newInterval's end then since start and end both greater
        //than new interval's end its a brand new interval
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        
        res.add(newInterval); //the newIntervall will be our consolidated interval with the param newInterval;
        
        //adding the rest to the result;
        while(i<intervals.length)
            res.add(intervals[i++]);
        
        return res.toArray(new int[res.size()][]);
    }
}
