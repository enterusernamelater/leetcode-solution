package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * use stack push everything in until we see ']' then we pop until we reach '[' to get val
 * then we get the multiple k by loop keeping popping with in the number hash set
 * once set.contains to peek return false then we compute the string and push back to the stack
 * in the end we pop stack one more time to get the result.
 * 
 * Time O(n) Space O(n)
 */
public class DecodeString {
	public DecodeString() {}

	@SuppressWarnings("serial")
	private Set<String> set = new HashSet<String>(){{
		add("0");
		add("1");
		add("2");
		add("3");
		add("4");
		add("5");
		add("6");
		add("7");
		add("8");
		add("9");
	}};

	public String decodeString(String s) {
		char[] arr = s.toCharArray();
		Deque<String> stack = new ArrayDeque<>();
		for(char c : arr){
			if(']' != c){
				stack.push(String.valueOf(c));
			}else{
				String tmp = "";
				while(!stack.isEmpty()){
					String str = stack.pop();
					if("[".equals(str)) break;
					tmp = str + tmp;
				}

				String res = "";

				while(set.contains(stack.peek())) res = stack.pop() + res;

				int k = Integer.valueOf(res);

				res = "";
				for(int i=0;i<k;i++){
					res += tmp;
				}
				stack.push(res);
			}
		}

		String res = "";
		while(!stack.isEmpty()){
			res = stack.pop() + res;
		}

		return res;
	}
}
