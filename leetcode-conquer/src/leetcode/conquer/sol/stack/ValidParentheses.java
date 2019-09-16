package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * this is a basic stack question..
 * Time O(n) Space O(n)
 */
public class ValidParentheses {
	public ValidParentheses() {}
	private Deque<Character> stack = new ArrayDeque<>();
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == '{' || c == '(' || c == '['){
                stack.push(c);
            }else if(c == '}'){
                if(stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            }else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }else if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }else{
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
