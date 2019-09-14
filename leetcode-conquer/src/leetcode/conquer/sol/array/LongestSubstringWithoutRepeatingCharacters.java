package leetcode.conquer.sol.array;

import java.util.HashSet;
import java.util.Set;

/*
 * This is another classic question 
 * using a set to keep track the unique ones and if a dup found remove all the ones before the dup and the dup
 * in the set. the max set size is the return
 * Tiem O(n) Space O(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public LongestSubstringWithoutRepeatingCharacters() {}
	
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int i=0;
        int res = 1;
        for(int j=1;j<s.length();j++){
            if(set.contains(s.charAt(j))){
                while(i<s.length() && s.charAt(i) != s.charAt(j)) set.remove(s.charAt(i++));
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
            res = Math.max(j-i+1,res);
        }
        return res;
    }
}
