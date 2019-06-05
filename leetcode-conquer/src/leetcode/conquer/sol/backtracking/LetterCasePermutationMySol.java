package leetcode.conquer.sol.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * my sol. dont need the for loop because this will create repeat combinations due to the second call to the method
 */
public class LetterCasePermutationMySol {
	public LetterCasePermutationMySol() {}
	
	private Set<String> res = new HashSet<>();
	public List<String> letterCasePermutation(String s) {
		helper(s,"",0);
		return new ArrayList<>(res);
	}

	private void helper(String s, String cur, int start){
		if(cur.length()==s.length()){
			res.add(cur);
			return;
		}

		for(int i=start;i<s.length();i++){
			char c = Character.isLetter(s.charAt(i)) ? Character.toUpperCase(s.charAt(i)) : s.charAt(i);
			helper(s,cur+c,i+1);
			c = Character.isLetter(s.charAt(i)) ? Character.toLowerCase(s.charAt(i)) : s.charAt(i);
			helper(s,cur+c,i+1);
		}
	}
}
