package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * see explanation below:
 * Time O(n) Space O(n)
 * self wrote 
 * test example:
 * (  ( ( (   5 +6) * (5  +1 )   )   -   ((   5   -   8 ) +( 1*3  )  ) )*( 1 *4   )  )
 */
public class BasicCalculatorIII {
	public BasicCalculatorIII() {}
	
	public int calculate(String s) {
		if(s == null || s.length() == 0) return 0;

		int number =0;
		char sign = '+';
		//stackI calculates within the parentheses
		Deque<Integer> stackI = new ArrayDeque<>();
		//stackII backsup all vals outside current parentheses
		Deque<String> stackS = new ArrayDeque<>();
		//stackII store all signs before the opening parentheses
		Deque<Character> stackC = new ArrayDeque<>();

		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				number = number*10 +(int)(c-'0');
			}

			if(c == '('){
				/*
				 * when encounter '(' dump all stack vals from stackI to stackS so
				 * the stackI will be a new stack to calculate values within the ()
				 * also push ( into stackS as a separation mark for later pop
				 * reset number to 0 and sign to +
				 * also push the sign into stackC, we pop stackC once a () is calculated 
				 */
				stackS.push(String.valueOf(c));
				while(!stackI.isEmpty()) stackS.push(String.valueOf(stackI.pop()));
				stackC.push(sign);
				number = 0;
				sign = '+';
			}else if(c == ')'){
				//when closing on ')' first push the last number into the stackI based on the previous sign
				pushStack(stackI, sign, number,false);

				//empty out stackI to calculate the final res within the ()
				int res = 0;
				while(!stackI.isEmpty()) res+=stackI.pop();
				//we need to push anything before the () from stackS back to stackI we stop pushing if we encounter '(' in stackS
				while(!stackS.isEmpty() && !"(".equals(stackS.peek())) stackI.push(Integer.valueOf(stackS.pop()));
				stackS.pop(); //pop the open (

				//pushing res back to the stackI by pop the stackC which stores the previous sign
				//only when close parentheses we allow push res=0 to stack
				pushStack(stackI, stackC.pop(), res,true);

				//reset number to 0 and sign to default
				number = 0;
				sign = '+';
			}else if(i+1 == s.length() || c != ' ' && !Character.isDigit(c)){
				//when no parentheses we push the number into stack based on its previous sign. (same as basic calculator II) 
				pushStack(stackI, sign, number,false);
				number = 0;
				sign = c;
			}
		}

		int res = 0;
		while(!stackI.isEmpty()) res+=stackI.pop();
		return res;
	}

	private void pushStack(Deque<Integer> stack, char op, int num, boolean close) {
		if(close || num != 0) {
			if(op =='+'){
				stack.push(num);
			}else if(op == '-'){
				stack.push(-num);
			}else if(op =='/'){
				stack.push(stack.pop()/num);
			}else if(op == '*'){
				stack.push(stack.pop()*num);
			}	
		}
	}
}
