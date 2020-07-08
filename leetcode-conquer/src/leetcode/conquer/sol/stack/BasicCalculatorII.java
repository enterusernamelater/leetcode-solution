package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * the idea of this solution is push a number with its previous sign into stack if is +/-.
 * to do so, when we encounter a operation sign we first push the number with its sign obtained from previous store
 * into stack then we renew the sign = c. 
 * Note that if operation is * or / we pop stack val (* or /) current val because * and / always take priority
 * 
 * Time O(n) Space O(n)
 */
public class BasicCalculatorII {
	public BasicCalculatorII() {}

	//using long protecting over flow
	public int calculate(String s) {
		long number = 0;
		char sign = '+';
		Deque<Long> stack = new ArrayDeque<>();
		char[] arr = s.toCharArray();

		for(char c : arr){
			if(c == ' ') continue;
			if(Character.isDigit(c)){
				number = number*10 + c-'0';
			}else if(sign == '+'){
				stack.push(number);
				number = 0;
				sign = c;
			}else if(sign == '-'){
				stack.push(-number);
				number = 0;
				sign = c;
			}else if(sign == '*'){
				stack.push(stack.pop() * number);
				number = 0;
				sign = c;
			}else if(sign == '/'){
				stack.push(stack.pop() / number);
				number = 0;
				sign = c;
			}
		}

		if(number != 0){
			if(sign == '+') stack.push(number);
			else if(sign == '-') stack.push(-number);
			else if(sign == '*') stack.push(stack.pop() * number);
			else if(sign == '/') stack.push(stack.pop() / number);
		}

		Long res = 0l;
		while(!stack.isEmpty()) res+=stack.pop();

		return res.intValue();
	}

	/*
	 * when we see a sign calculate the previous combo and push the combo in the the new sign
	 * when see a * and / you can only calculate one combo and attach with the new sign
	 * when you dont have a * and / in the stack meaning stack.peek the sign is not * and /
	 * you can calculate all combo in the stack bottom to top 
	 * Time O(n)
	 * space constant
	 */
	public int calculateMySol(String s) {
		if(s == null || s.length() == 0) return 0;
		Deque<String> stack = new ArrayDeque<>();
		int i=0;
		s = s.replaceAll(" ","");
		for(int j=0;j<s.length();j++){
			if(s.charAt(j) == '+' || s.charAt(j) == '-' || j == s.length() - 1){
				String str2 = s.substring(i,j == s.length()-1? j+1 : j);
				//only calulate previous if * and /
				if(!stack.isEmpty() && stack.peek().equals("*")){
					stack.pop();
					String str1 = stack.pop();
					stack.push(String.valueOf(Long.valueOf(str1) * Long.valueOf(str2)));
				}else if(!stack.isEmpty() && stack.peek().equals("/")){
					stack.pop();
					String str1 = stack.pop();
					stack.push(String.valueOf(Long.valueOf(str1) / Long.valueOf(str2)));
				}else{
					//calculate all from stack bottom to top using poll last
					stack.push(str2);
					stack.push(String.valueOf(calculate(stack)));
				}
				if(j == s.length()-1)continue;
				i=j+1;
				stack.push(String.valueOf(s.charAt(j)));
			}else if(s.charAt(j) == '*' || s.charAt(j) == '/'){ // when * and / reached only calculate previous * and / combos
				String str2 = s.substring(i,j);
				if(!stack.isEmpty() && stack.peek().equals("*")){
					stack.pop();
					String str1 = stack.pop();
					stack.push(String.valueOf(Long.valueOf(str1) * Long.valueOf(str2)));
				}else if(!stack.isEmpty() && stack.peek().equals("/")){
					stack.pop();
					String str1 = stack.pop();
					stack.push(String.valueOf(Long.valueOf(str1) / Long.valueOf(str2)));
				}else{
					stack.push(str2);
				}
				i=j+1;
				stack.push(String.valueOf(s.charAt(j)));
			}
		}

		return calculate(stack);
	}

	private int calculate(Deque<String> stack){
		int sum = 0;
		while(!stack.isEmpty()){
			String str = stack.pollLast();
			if(str.equals("+")){
				sum+=Integer.valueOf(stack.pollLast());
			}else if(str.equals("-")){
				sum-=Integer.valueOf(stack.pollLast());
			}else{
				sum+=Integer.valueOf(str);
			}
		}
		return sum;
	}
}
