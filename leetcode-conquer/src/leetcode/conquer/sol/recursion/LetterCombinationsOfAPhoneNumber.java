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
    private List<String> res;
    private String s;
    private Map<Character,String> map;
    private int len;
    public List<String> letterCombinations(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        this.s = s;
        this.res = new ArrayList<>();
        this.len = 0;
        this.map = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        
        for(int i=0;i<s.length();i++) if(s.charAt(i) != '1') len++;
        helper("",0);
        
        return res;
    }
    
    private void helper(String curr, int index){
        if(curr.length() == len){
            res.add(curr);
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))continue;
            String val = map.get(s.charAt(i));
            for(int j=0; j<val.length(); j++){
                helper(curr+val.charAt(j), i+1);
            }
        }
    }
}
