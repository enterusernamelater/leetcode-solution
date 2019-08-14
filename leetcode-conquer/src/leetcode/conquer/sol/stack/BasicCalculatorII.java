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
	
	public int calculate(String s) {
        if(s == null || s.length() ==0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char sign = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number*10 +(int)(c-'0');
            }
            
            if(i+1 == s.length() || c != ' ' && !Character.isDigit(c)){
                if(sign =='+'){
                    stack.push(number);
                    number = 0;
                }else if(sign == '-'){
                    stack.push(-number);
                    number = 0;
                }else if(sign =='/'){
                    stack.push(stack.pop()/number);
                    number = 0;
                }else if(sign == '*'){
                    stack.push(stack.pop()*number);
                    number = 0;
                }
                
                sign = c;
             }
        }
        
        int res = 0;
        while(!stack.isEmpty()) res+=stack.pop();
        return res;
    }
}
