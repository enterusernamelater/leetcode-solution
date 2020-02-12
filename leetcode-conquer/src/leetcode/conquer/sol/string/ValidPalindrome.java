package leetcode.conquer.sol.string;

/*
 * skip char if not digit and not char
 * while l++ and r-- see if same if not return false
 * otherwise return true;
 * Time O(N) Space constant
 */
public class ValidPalindrome {
	public ValidPalindrome() {}

	public boolean isPalindrome(String s) {
		if(s == null || s.length() == 0) return true;
		char[] arr = s.toCharArray();
		int l = 0;
		int r = arr.length-1;

		while(l<r){
			while(l<r && !Character.isLetter(arr[l]) && !Character.isDigit(arr[l]))l++;
			while(l<r && !Character.isLetter(arr[r]) && !Character.isDigit(arr[r]))r--;
			if(Character.toLowerCase(arr[l++]) != Character.toLowerCase(arr[r--])) return false;
		}

		return true;
	}
}
