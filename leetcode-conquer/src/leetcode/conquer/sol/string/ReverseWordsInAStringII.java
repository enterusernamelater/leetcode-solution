package leetcode.conquer.sol.string;

/*
 * first reverse the whole string then just reverse one word a time
 * Time O(n)
 * Space constant
 */
public class ReverseWordsInAStringII {
	public ReverseWordsInAStringII() {}
	
    public void reverseWords(char[] s) {
        int l = 0;
        int r = s.length-1;
        while(l<r) reverse(s,l++,r--);
        
        l=0;
        for(int j=0;j<s.length;j++){
            if(s[j] == ' ' || j+1 == s.length){
                r = j+1 == s.length? j : j-1;
                while(l<r) reverse(s,l++,r--);
                l=j+1;
            }
        }
    }
    
    private void reverse(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
