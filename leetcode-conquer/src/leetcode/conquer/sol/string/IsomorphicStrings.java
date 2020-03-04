package leetcode.conquer.sol.string;

/*
 * loop through string s finding if each char has a duplicate replacement
 * loop through string t finding if each char has a duplicate replacement
 * if non we have a true otherwise return false.
 * Time O(n)
 * Space O(n)
 */
public class IsomorphicStrings {
	public IsomorphicStrings() {}

	public boolean isIsomorphic(String s, String t) {
		if(s.equals(t)) return true;
		char[] arr = new char[128];

		char[] carr1 = s.toCharArray();
		char[] carr2 = t.toCharArray();

		for(int i=0;i<carr1.length;i++){
			char val = arr[carr1[i]];
			if(val != '\u0000' && val != carr2[i]) return false;
			arr[carr1[i]] = carr2[i];
		}
		arr = new char[128];
		for(int i=0;i<carr1.length;i++){
			char val = arr[carr2[i]];
			if(val != '\u0000' && val != carr1[i]) return false;
			arr[carr2[i]] = carr1[i];
		}

		return true;
	}
}
