package leetcode.conquer.sol.array;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * simple stack add and pop solution
 * add the vals and push to stack later we pop
 * Time O(N) Space O(N)
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        Deque<Integer> stack =new ArrayDeque<>();
        int carry = 1;
        for(int i = digits.length-1;i>=0;i--){
            int val = digits[i];
            stack.push((val+carry) % 10);
            carry = (val+carry)/10;
        }
        if(carry > 0) stack.push(carry);
        int[] res = new int[stack.size()];
        for(int i=0;i<res.length;i++) res[i] = stack.pop();
        return res;
    }
}
