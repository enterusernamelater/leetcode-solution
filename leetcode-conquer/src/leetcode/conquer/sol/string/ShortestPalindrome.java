package leetcode.conquer.sol.string;

/*
 * Time O(n^2)
 * Space constant
 */
public class ShortestPalindrome {
	public ShortestPalindrome() {}

	public String shortestPalindrome(String s) {
		if(s == null || s.length() == 0) return s;
		int i=0;
		int j=s.length()-1;
		int start = s.length() - 1; // start meaning the start of the none Palindrome string
		char[] arr = s.toCharArray();
		while(i<j){
			if(arr[i] == arr[j]){
				i++;
				j--;
			}else{
				i = 0; //we reset i to the start
				start--; // assume the start of the none palindrome is start--
				j=start; //now we see if i to j (the new j) is a palindrome.
			}
		}
		//in the end we either find a palindrome between i and j or the start turn back to 0.
		//regardless, we reverse substring after start+1, and append to the beginning of the string s 
		//making the whole string palindrome.

		return new StringBuilder(s.substring(start+1)).reverse().append(s).toString();
	}
}
