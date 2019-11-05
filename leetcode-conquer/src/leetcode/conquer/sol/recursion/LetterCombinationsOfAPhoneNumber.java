package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * backtracking combination solution with a map that tracks the vals for each digit
 * time complexity o(4N) since the worst digits have four letters 4*4*4*4..depending on number of digits
 * space complexity also o(4n)
 */
public class LetterCombinationsOfAPhoneNumber {
	public LetterCombinationsOfAPhoneNumber() {}
	private Map<Character,String> map = new HashMap<Character,String>(){{
		put('2',"abc");
		put('3',"def");
		put('4',"ghi");
		put('5',"jkl");
		put('6',"mno");
		put('7',"pqrs");
		put('8',"tuv");
		put('9',"wxyz");
	}};

	private List<String> res = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0) return res;

		char[] arr = digits.toCharArray();
		dfs(arr,0,"",digits);
		return res;
	}

	private void dfs(char[] arr, int idx, String curr, String digits){
		if(curr.length() == digits.length()){
			res.add(curr);
			return;
		}

		String str = map.get(arr[idx]);
		for(char c : str.toCharArray()){
			dfs(arr,idx+1,curr+c,digits);
		} 
	}
}
