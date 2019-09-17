package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * This is a classic recursion question. 
 * in a way that we track if close parentheses is more than the open parentheses if so 
 * we move on to the next recursion see comment.
 * left and right competes under the condition left > right untill all results are found.
 * Time O(2^n) space constant
 */
public class GenerateParentheses {
	public GenerateParentheses() {}

    private List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        if(n == 0) return res;
        helper("",n,n);
        return res;
    }
    private void helper(String curr, int left, int right){
        //This condition is important because when we have more right (close ")") than the left 
        //we cannot complete the parentheses. more means we have less available right (close ")") than the left.
        if(left > right) return;
        
        if(left == 0 && right == 0){
            res.add(curr);
            return;
        }
        
        if(left > 0){
            helper(curr+"(", left-1, right);
        }
        
        if(right > 0){
            helper(curr+")", left, right-1);
        }   
    }
}
