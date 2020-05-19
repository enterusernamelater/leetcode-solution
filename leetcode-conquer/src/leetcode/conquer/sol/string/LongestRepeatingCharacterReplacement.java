package leetcode.conquer.sol.string;


/*
 * Since we are only interested in the longest valid substring, 
 * our sliding windows need not shrink, even if a window may cover an invalid substring. 
 * We either grow the window by appending one char on the right, 
 * or shift the whole window to the right by one. 
 * And we only grow the window when the count of the new char exceeds the historical 
 * max count (from a previous window that covers a valid substring). 
 * That is, we do not need the accurate max count of the current window; 
 * we only care if the max count exceeds the historical max count; 
 * and that can only happen because of the new char.
 * 
 * Time O(n)
 * space constant
 */
public class LongestRepeatingCharacterReplacement {
	public LongestRepeatingCharacterReplacement() {}

	public int characterReplacement(String s, int k) {
		if(s == null || s.length() == 0) return 0;
		char[] chs = s.toCharArray();
		int[] count = new int[26];
		int i=0;
		int res = 0;
		int maxCount = 0;
		for(int j=0;j<chs.length;j++){
			maxCount = Math.max(maxCount,++count[chs[j]-'A']);

			while(j-i+1-maxCount > k){
				count[chs[i++]-'A']--;
			}

			res = Math.max(res,j-i+1);
		}
		return res;
	}
}
