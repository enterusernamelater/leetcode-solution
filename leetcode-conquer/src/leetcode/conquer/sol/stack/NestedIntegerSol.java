package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.conquer.sol.recursion.util.NestedInteger;

/*
 * this solution is pretty straight forward, when we encounter a [ we push the current NestedInteger list for later pop
 * and create a brand new one
 * when encounter ] we add the final number and then peek the stack and adding the curr NestedInteger list into the stack's peek
 * and pop the stack and making curr equals to the stack pop.
 * when the last ] is hit the stack will be emptied and the curr will be the final stack pop
 * 
 * Time O(n) Space O(n)
 */
public class NestedIntegerSol {
	public NestedIntegerSol() {}

	public NestedInteger deserialize(String s) {
		if(s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s)); // invalid

		Deque<NestedInteger> stack = new ArrayDeque<>();
		NestedInteger curr = null;
		int l = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(c =='['){
				if(curr != null){
					stack.push(curr);
				}
				curr = new NestedInteger();
				l = i+1;
			}else if(c == ']'){
				String str = s.substring(l,i);
				if(str != null && str.length() > 0){
					curr.add(new NestedInteger(Integer.valueOf(str)));
				}
				if(!stack.isEmpty()){
					stack.peek().add(curr);   
					curr = stack.pop();
				}
				l = i + 1;
			}else if(c == ','){
				String str = s.substring(l,i);
				if(str != null && str.length() > 0){
					curr.add(new NestedInteger(Integer.valueOf(str)));
				}
				l = i+1;
			}
		}
		return curr;
	}
}
