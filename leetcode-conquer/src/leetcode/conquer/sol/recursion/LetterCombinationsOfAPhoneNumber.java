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
    Map<String,String> map = new HashMap<String,String>(){
		private static final long serialVersionUID = 1L;
	{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};
    
    List<String>  res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        helper(digits,"");
        return res;
    }
    
    private void helper(String s, String comb){
        if(s == null || s.length()==0){
            res.add(comb);
            return;
        }
        
        String digitStr = map.get(s.substring(0,1));
        for(char c : digitStr.toCharArray()){
            helper(s.substring(1), comb+c);
        }
    }
}
