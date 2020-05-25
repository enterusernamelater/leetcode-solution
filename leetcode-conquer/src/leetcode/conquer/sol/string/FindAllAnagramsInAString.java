package leetcode.conquer.sol.string;
import java.util.*;

/*
 * Sliding window with p.length(). check if the sliding window equals p if so store the starting of the sliding window
 * remove the j and increment j when sliding window reach the max
 * Time O(N)
 * space constant
 */
public class FindAllAnagramsInAString {
	public FindAllAnagramsInAString() {}

	public List<Integer> findAnagrams(String s, String p) {
		if(s == null || s.length() == 0) return new ArrayList<>();
		if(s.length()<p.length()) return new ArrayList<>();
		int[] schs = new int[26];
		int[] pchs = new int[26];
		for(char c : p.toCharArray()) pchs[c-'a']++;
		int n = p.length();
		List<Integer> res = new ArrayList<>();
		int j=0;
		for(int i=0;i<s.length();i++){
			schs[s.charAt(i)-'a']++;
			if(i-j+1 > n){
				schs[s.charAt(j++)-'a']--;
			}

			if(Arrays.equals(schs,pchs)) res.add(j);
		}

		return res;
	}
}
