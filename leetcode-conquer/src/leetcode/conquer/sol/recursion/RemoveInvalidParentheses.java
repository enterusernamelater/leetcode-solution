package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * first we need to calculate the extra open and close parentheses and use backtracking to remove the extra open and close
 * parentheses one at a time. once a parentheses is removed the recursion starts at the new index as the previous is already considered
 * each time we remove the parentheses we check if the newly formed string is valid if so we added to the string
 * if not valid, we continue removing continue no valid match then we back track.
 * 
 */
public class RemoveInvalidParentheses {
	public RemoveInvalidParentheses() {}

	private List<String> res = new ArrayList<>();
	public List<String> removeInvalidParentheses(String s) {
		int open = 0;
		int close = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(') open++;
			else if(open == 0 && s.charAt(i) == ')') close++;
			else if(s.charAt(i) == ')') open--;
		}

		helper(open,close,s,0);
		if(res.isEmpty()) res.add("");
		return res;
	}

	private void helper(int open, int close, String s, int index){
		if(isValid(s)){
			res.add(s);
			return;
		}

		//resetting the index because the previous indexes are already checked
		for(int i=index; i<s.length(); i++){
			if(i>0 && s.charAt(i) == s.charAt(i-1)) continue; //ignore the repeat because the previous is already calculated
			if(s.charAt(i) == '(' && open > 0){
				helper(open-1, close, s.substring(0,i) + s.substring(i+1, s.length()),i);
			}else if(s.charAt(i) == ')' && close > 0){
				helper(open, close-1, s.substring(0,i) + s.substring(i+1, s.length()),i);
			}
		}
	}

	private boolean isValid(String s){
		if(s== null || s.length() == 0) return false;
		char[] arr = s.toCharArray();
		int count = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] == '(') count++;
			else if(arr[i] == ')') count--;

			if(count < 0) return false;
		}

		return count == 0;
	}
}
