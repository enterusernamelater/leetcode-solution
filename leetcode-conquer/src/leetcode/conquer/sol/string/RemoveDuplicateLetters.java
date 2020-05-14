package leetcode.conquer.sol.string;

/*
 * best explanation ever https://www.youtube.com/watch?v=SrlvMmfG8sA
 * 
 * Time O(n^2)
 * Space O(n)
 */ 
public class RemoveDuplicateLetters {
	public RemoveDuplicateLetters() {}
	
	public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return s;
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars) count[c-'a']++;
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        
        for(char c : chars){
            count[c-'a']--;
            if(used[c-'a']) continue;
            
            while(sb.length()>0 && sb.charAt(sb.length()-1) > c && count[sb.charAt(sb.length()-1)-'a']>0){
                used[sb.charAt(sb.length()-1)-'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c);
            used[c-'a'] = true;
        }
        
        return sb.toString();
    }
}
