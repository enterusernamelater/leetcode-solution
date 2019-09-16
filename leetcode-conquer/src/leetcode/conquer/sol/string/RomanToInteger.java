package leetcode.conquer.sol.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Substring all valid roman (once a non-valid one found the move j index 1 before) in the map and add to the result
 * Time O(n) Space Constant
 */
public class RomanToInteger {
	public RomanToInteger() {}

	public int romanToInt(String s) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("IV",4);
		map.put("IX",9);
		map.put("XL",40);
		map.put("XC",90);
		map.put("CD",400);
		map.put("CM",900);
		map.put("I",1);
		map.put("V",5);
		map.put("X",10);
		map.put("L",50);
		map.put("C",100);
		map.put("D",500);
		map.put("M",1000);

		int i = 0;
		int res = 0;
		for(int j = 1; j<=s.length();j++){
			String val = s.substring(i,j);
			if(j==s.length() && map.containsKey(val)){
				res+= map.get(val);
			}else if(!map.containsKey(val)){
				res += map.get(s.substring(i,--j));
				i=j;
			}
		}
		return res;
	}
}
