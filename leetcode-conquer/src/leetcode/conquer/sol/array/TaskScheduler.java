package leetcode.conquer.sol.array;

import java.util.Arrays;

/*
 * this is a greedy solution, we first findout the max frequency task then we create all the idle slots based on the 
 * max frequency task -1 because after excuting the last task there is no need for idle
 * then we decrease the idle slots by filling the slots with tasks. the min protects when we have duplicate max frequency tasks 
 * the "-1" will also apply
 * youtube link:
 * https://www.youtube.com/watch?v=eGf-26OTI-A
 * Time O(n) Space constant
 */
public class TaskScheduler {
	public TaskScheduler() {}
	
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        int[] chs = new int[26];
        for(char c : tasks) chs[c-'A']++;
        
        Arrays.sort(chs);
        int max = chs[25]-1;
        int slots = max*n;
        
        for(int i=24;i>=0;i--){
            slots -= Math.min(chs[i],max);
        }
        
        return slots>0? slots+tasks.length : tasks.length;
    }
}
