package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * push when the stack peek doesn't match the pointer at j
 * pop when match until not matching again
 * in the end check if we have remaining j to pop
 * if j is finished but still has remaining non pushed i return false;
 * in the end we return if stack is empty and i and j has reached the end
 * Time O(n)
 * Space O(n)
 */
public class ValidateStackSequences {
	public ValidateStackSequences() {}
	
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i=0, j=0;
        while(i<pushed.length && j<popped.length){
            if(stack.isEmpty() || stack.peek() != popped[j]){
                stack.push(pushed[i++]);
            }else if(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        if(j==popped.length && i<pushed.length) return false;
        while(!stack.isEmpty() && j<popped.length && stack.peek() == popped[j]){
                stack.pop();
                j++;
        }
        
        return stack.isEmpty() && i==pushed.length && j==popped.length;
    }
}
