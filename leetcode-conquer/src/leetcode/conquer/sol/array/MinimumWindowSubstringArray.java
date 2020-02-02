package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.Map;

/*
 * we keep a sliding window i and j, and using count to track the total length reached to t string
 * a map will keep track of number of chars appeared in the t string
 * during expanding the sliding window before count reaches to the t string length
 * we decrement the char's count number in the map, only increment count if the char's total count in the map is still above 0
 * (its possible to have cases like AAABC, when t is ABC)
 * Once count reached to the t's length, we starting shrink the sliding window by now incrementing i.
 * if map contains char at i in s. we increment the total count of char in s in the map, once the total count of char returns to positive
 * now we know the count in the sliding window is invalid, now while loop breaks and j moves forward until the count reaches t length again
 * then i start catching up by shrinking the sliding window once again
 * 
 * The KEY to this problem is how we use the total count value of a char in the map to maintain the balance of the sliding window. 
 * sliding window expand when map value still positive
 * sliding window shrinks when map value reaches positive. meaning now we need more of this current char to reach a valid state to match t.
 * 
 * Time O(N)
 * Space O(N)
 */
public class MinimumWindowSubstringArray {
	public MinimumWindowSubstringArray() {}

	public String minWindow(String s, String t) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0; i<t.length();i++){
			map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
		}

		int i=0, count = 0, start = 0, end = Integer.MAX_VALUE;
		for(int j=0;j<s.length();j++){
			if(!map.containsKey(s.charAt(j))) continue;

			int val = map.get(s.charAt(j));
			if(val-- > 0) count++;
			map.put(s.charAt(j), val);
			while(count == t.length()){
				if(!map.containsKey(s.charAt(i))){
					i++;
					continue;
				}

				if(j+1-i < end - start){
					start = i;
					end = j+1; 
				}

				val = map.get(s.charAt(i));
				map.put(s.charAt(i++), ++val);
				if(val > 0) count--;
			}
		}

		return end == Integer.MAX_VALUE? "" : s.substring(start,end);
	}
}
