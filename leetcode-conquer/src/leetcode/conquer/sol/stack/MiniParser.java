package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.conquer.sol.recursion.util.NestedInteger;

/*
 * This solution uses stack,
 * first we need to handle a special case where the string is all digits in that case we return a new node
 * when we encounter a [ we save the current node in stack and create a new node
 * when we encounter a ',' we add the substring integer starting at i ending at ',' to the curr node
 * when we ecounter a ] we add the substring integer starting at i ending at ] to the curr node and pop back the previous node
 * and add the curr node to the previous node
 * in all cases above we will always need to update the i pointer. so the i pointer is ready for the next unread position
 * Time O(n)
 * Space O(N)
 */
public class MiniParser {
	public MiniParser() {}

	public NestedInteger deserialize(String s) {
		if(s == null || s.length() == 0) return null;
		if(s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));

		Deque<NestedInteger> stack = new ArrayDeque<>();
		NestedInteger curr = new NestedInteger();
		int i=1;
		for(int j=1;j<s.length();j++){
			if(s.charAt(j) == '['){
				//save the current nestednode
				stack.push(curr);
				curr = new NestedInteger(); 
				i=j+1;
			}else if(s.charAt(j) == ']'){
				String sub = s.substring(i,j);
				i=j+1;
				if(!sub.isBlank())
					curr.add(new NestedInteger(Integer.valueOf(sub)));

				if(!stack.isEmpty()){
					stack.peek().add(curr);
					curr = stack.pop();
				}
			}else if(s.charAt(j) == ','){
				String sub = s.substring(i,j);
				i=j+1;
				if(!sub.isBlank())
					curr.add(new NestedInteger(Integer.valueOf(sub)));
			}
		}

		return curr;
	}
}
