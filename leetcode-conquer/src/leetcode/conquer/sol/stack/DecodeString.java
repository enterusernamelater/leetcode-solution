package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * use stack, stack stores 2 things  a repeating number at the top and the previous string
 * when encounter a number we store the previous string and the number on top
 * when we see a ] we pop the number and repeat the current string
 * then pop the stack to obtain the previous string and attach the current string to the previous string, the whole string now
 * is the current string, loop continues.
 * else we know its a letter we just use the string builder
 * 
 * all calculation above is done using string builder.
 * 
 * Time O(n) Space O(n)
 */
public class DecodeString {
	public DecodeString() {}

	public String decodeString(String s) {
		if(s == null || s.isEmpty()) return s;

		Deque<StringBuilder> stack = new ArrayDeque<>();
		StringBuilder curr = new StringBuilder();

		for(int i=0;i<s.length();i++){
			if(Character.isDigit(s.charAt(i))){
				stack.push(curr);
				int j=i;
				//the while loop here because the number can be multiple digits. 
				while(j<s.length() && s.charAt(j) != '[') j++;
				stack.push(new StringBuilder(s.substring(i,j)));
				curr = new StringBuilder();
				i=j;
			}else if(s.charAt(i) == ']'){
				int size = Integer.valueOf(stack.pop().toString());
				String val = curr.toString();
				for(int k=0;k<size-1;k++) curr.append(val);
				//no need to check if is Empty string always valid 
				//worst case an empty sb will return as its added in the first place.
				stack.peek().append(curr.toString());
				curr = stack.pop();
			}else{
				curr.append(s.charAt(i));
			}
		}

		return curr.toString();
	}
}
