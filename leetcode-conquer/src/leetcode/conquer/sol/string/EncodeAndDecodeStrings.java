package leetcode.conquer.sol.string;

import java.util.ArrayList;
import java.util.List;

/*
 * adding a key code to every end of a string and decode the string by using s.indexof the key code
 * Time O(n)
 * Space O(n)
 */
public class EncodeAndDecodeStrings {
	public EncodeAndDecodeStrings() {}
	
    // Encodes a list of strings to a single string.
    private final String key = "jhe1006";
    private final int size = 7;
    private List<List<Integer>> list = new ArrayList<>();
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i));
            sb.append(key);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int idx = s.indexOf(key,i);
            list.add(s.substring(i,idx));
            i=idx+size;
        }
        return list;
    }
}
