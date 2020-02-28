package leetcode.conquer.sol.string;

/*
 * split and reverse each string using string builder reverse
 * Time O(N)
 * space O(n)
 */
public class ReverseWordsInAStringIII {
	public ReverseWordsInAStringIII() {}
	
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder(arr[0]);
        res.reverse();
        for(int i=1;i<arr.length;i++){
            StringBuilder sb = new StringBuilder(arr[i]);
            res.append(" ");
            res.append(sb.reverse());
        }
        
        return res.toString();
    }
}
