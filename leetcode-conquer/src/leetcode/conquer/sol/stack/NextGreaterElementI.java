package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * using stack storing numbers in decreasing order. when a num appears greater than stack peek you know you have found the stack peek number's
 * NextGreaterElementI
 * 
 * Time O(n)
 * Space O(n)
 */
public class NextGreaterElementI {
	public NextGreaterElementI() {}
	
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i])
                map.put(stack.pop(),nums2[i]);
            
            stack.push(nums2[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int val : nums1){
            list.add(map.getOrDefault(val,-1));
        }
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        
        return res;
    }
}
