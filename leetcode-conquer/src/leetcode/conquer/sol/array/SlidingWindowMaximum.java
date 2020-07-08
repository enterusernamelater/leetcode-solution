package leetcode.conquer.sol.array;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * the stack keeps a bottom to top max to min numbers
 * when a window has reached we peek the last max that push to the res arr
 * and if the window's edge i happen to be the max we need to pull from the stack last.
 * Space O(n)
 */
public class SlidingWindowMaximum {
	public SlidingWindowMaximum() {}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> stack = new ArrayDeque<>(); //the stack keeps a bottom to top max -> min
        int i=0; // two pointer windows size;
        for(int j=0;j<nums.length;j++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[j]) stack.pop();
            stack.push(j);
            if(j-i+1 == k){
                res[i] = nums[stack.peekLast()];
                if(i == stack.peekLast()) stack.pollLast();
                i++;
            }
        }
        return res;
    }
}


