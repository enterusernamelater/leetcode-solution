package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * a divid and conquer solution, when we loop through the section of the given string 
 * we divide the string if char -,+,* is found. and continue finding each section's result
 * when all section results are returned for the current section we + , _ or * on the left and right results
 * of the current section.
 * each time a section results are calcualted. the results are added to a map so that the section dont need to be
 * calculated again
 */
public class DifferentWaysToAddParentheses {
	public DifferentWaysToAddParentheses() {}

	public List<Integer> diffWaysToCompute(String input) {
		if(input == null || input.length() == 0) return new ArrayList<>();
		Map<String,List<Integer>> map = new HashMap<>();
		return helper(input,map);
	}

	private List<Integer> helper(String s, Map<String,List<Integer>> map){
		if(map.containsKey(s)) return map.get(s);
		List<Integer> list = new ArrayList<>();

		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c == '+' || c == '-' || c =='*'){
				List<Integer> left = helper(s.substring(0,i),map);
				List<Integer> right = helper(s.substring(i+1,s.length()),map);
				for(int l : left){
					for(int r : right){
						if(c == '-') list.add(l-r);
						else if(c == '+') list.add(l+r);
						else list.add(l*r);
					}
				}
			}
		}
		//this is for adding a single number after split.
		if(list.size() == 0) list.add(Integer.valueOf(s));
		map.put(s,list);
		return list;
	}
}
