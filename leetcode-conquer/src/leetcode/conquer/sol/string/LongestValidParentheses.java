package leetcode.conquer.sol.string;

/*
 * the idea of this question is we loop forward once finding the valid amount of left and right
 * in parentheses question the invalid case is when closing parentheses is more than the opening
 * and then loop one time backwards to again finding the valid amount of left and right parentheses 
 * only in this time the close parentheses becomes open one.
 * in the end we pick the max valid left and rights between the two run
 * Time O(n) Space constant
 */
public class LongestValidParentheses {
	public LongestValidParentheses() {}
	
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int res =0;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '(') left++;
            else if(arr[i] == ')') right++;
            
            if(left == right) res = Math.max(res,left+right);
            else if(right>left) left = right = 0;
        }
        
        left = 0;
        right = 0;
        //loop backwards close parentheses becomes open
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] == ')') left++;
            else if(arr[i] == '(') right++;
            
            if(left == right) res =Math.max(res, left+right);
            else if(right>left) left = right = 0;
        }
        return res;
    }
}
