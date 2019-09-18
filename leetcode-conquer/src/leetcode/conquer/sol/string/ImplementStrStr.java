package leetcode.conquer.sol.string;

/*
 * use substring and some index length manipulation on the length
 * Time O(n) space constant
 */
public class ImplementStrStr {
	public ImplementStrStr() {}
	
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        
        for(int i=0; i<haystack.length() - needle.length() + 1; i++){
            if(haystack.substring(i,i + needle.length()).equals(needle)) return i;
        }
        
        return -1;
    }
}
