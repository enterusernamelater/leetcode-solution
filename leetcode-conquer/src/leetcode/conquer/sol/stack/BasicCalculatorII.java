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
}
