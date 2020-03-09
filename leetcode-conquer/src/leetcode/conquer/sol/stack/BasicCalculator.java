package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * The idea behind this solution is when we encounter a +/- the previous is ready to calculate (eg, A+B when encounter +, A is ready to calculate)
 * we add the previous to result with sign*number number being the previous and store the current sign and rebuild number by setting number to 0.
 * when next time +/- is encounter then a new number has been builded and another val can be added to the result.
 * when '(' encountered when push the result calculated and the stored sign into the stack Note LIFO, because sign will need to pop first later
 * reset result to 0, number to 0, sign to default 1 and follow the same logic above calculate the result in the brackets.
 * when ')' reached we first add the final number to the result then we change the sign of the result by pop the stack
 * then we add the result to the previous result from stack pop.
 * Time O(n) Space O(n)
 */
public class BasicCalculator {
	public BasicCalculator() {}

	//use long to protect overflow
    public int calculate(String s) {
        long sign = 1;
        long number = 0;
        long result  = 0;
        Deque<Long> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(Character.isDigit(c)){
                number = number*10 + c-'0';
            }else if(c == '-'){
                result+= sign*number;
                sign =-1;
                number = 0;
            }else if(c == '+'){
                result +=sign*number;
                sign=1;
                number = 0;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                number = 0;
                result = 0;
                sign = 1;
            }else if(c == ')'){
                result += sign*number;
                result *= stack.pop();
                result = stack.pop() + result;
                sign = 1;
                number = 0;
            }
        }
        
        return Long.valueOf(result+=sign*number).intValue();
    }
}
