package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * first we sort the intervals by its start, after than we compare each interval's start to the previous build
 * interval's end. if its within meaning start<end we include the current interval to the build interval
 * by updating the build interval's end to be the max of itself end or the current interval's end
 * if the current interval (i+1) is outside the build interval's scope we store the builded interval
 * and update the build interval to the current interval as the new start point 
 * Time O(nlog(n)) because the sort
 * Space O(n)
 */
public class MergeIntervals {
	public MergeIntervals() {}
	
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[][]{};
        List<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int[] val = intervals[0];
        for(int i = 0; i<intervals.length; i++){
            while(i+1<intervals.length && intervals[i+1][0] <= val[1]){
                val[1] = Math.max(val[1],intervals[i++ + 1][1]);
            }
            arr.add(val);
            if(i+1 < intervals.length) val = intervals[i+1];
        }
        
        int[][] res = new int[arr.size()][2];
        for(int i=0;i<arr.size();i++){
            res[i][0] = arr.get(i)[0];
            res[i][1] = arr.get(i)[1];
        }
        
        return res;
    }
    
    //more elegant solution, instead of while loop a if statement would do
    //in the end call arr.toArray instead of building a res myself
    public int[][] mergeSolTwo(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[][]{};
        List<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int[] val = intervals[0];
        for(int i = 0; i<intervals.length; i++){
            if(i+1<intervals.length && intervals[i+1][0] <= val[1]){
                val[1] = Math.max(val[1],intervals[i+1][1]);
            }else{
                arr.add(val);
                if(i+1 < intervals.length) val = intervals[i+1];
            }
        }
        
        return arr.toArray(new int[arr.size()][]);
    }
    
    //heap solution
    public int[][] mergeHeap(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> (a[0] -b[0]));
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) ->(b[1]-a[1]));
        for(int i=0;i<intervals.length;i++){
            
            if(!q.isEmpty() && q.peek()[1]>=intervals[i][0]){
                q.offer(new int[]{q.peek()[0], Math.max(q.poll()[1],intervals[i][1])});
            }else{
                q.offer(intervals[i]);
            }
        }
        
        return q.toArray(new int[q.size()][]);
    }
}
