package leetcode.conquer.sol.array;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * see comments below, Time O(n) two pass. 
 * Space O(n)
 */
public class SlidingWindowMaximum {
	public SlidingWindowMaximum() {}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length-k+1];
        //tracks res index
        int r =0;
        Deque<Integer> q = new ArrayDeque<>();
        //this question we always store the Max index in the queue's head and every loop if num is greater than 
        //last element in queue remove the last element until none.
        for(int i=0; i<nums.length;i++){
            //ensure the q is within the range of k by checking the first element index in the q also the MAX index
            if(!q.isEmpty() && q.peek()<i-k+1){
                q.poll();
            }
            //remove all lasts that are smaller than nums[i]
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            //add to Queue's head
            q.offer(i);
            //after the first k range start add result to res array
            if(i+1>=k) 
                res[r++] = nums[q.peek()];
        }
        return res;
    }
}
