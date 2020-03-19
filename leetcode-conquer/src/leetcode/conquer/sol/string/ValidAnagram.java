package leetcode.conquer.sol.string;

/*
 * ascii 128 solution. O(N) TIME O(N) SPACE
 */
public class ValidAnagram {
	public ValidAnagram() {}

	public boolean isAnagram(String s, String t) {
		int[] arr = new int[128];
		char[] carr1 = s.toCharArray();
		char[] carr2 = t.toCharArray();
		for(char c : carr1) arr[c]++;
		for(char c : carr2) arr[c]--;
		for(int i : arr) if(i != 0) return false;
		return true;
	}
}
