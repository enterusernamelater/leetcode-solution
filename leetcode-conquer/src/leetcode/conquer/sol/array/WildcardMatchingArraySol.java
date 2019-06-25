package leetcode.conquer.sol.array;

/*
 * this is an array sol with Time O(n) Space O(1)
 * link below for detailed explanation:
 * https://www.youtube.com/watch?v=-8QnRMyHo_o
 */
public class WildcardMatchingArraySol {
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        int match = 0;
        int star = -1;
        
        while(sp<s.length()){
            if(pp<p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                sp++;
                pp++;
            }else if(pp<p.length() && p.charAt(pp) == '*'){
                match = sp;
                star = pp;
                pp++;
            }else if(star != -1){
                sp = match + 1;
                match = sp;
                //we need to reset p in this case for example when p already at a far end but found a mismatch
                pp = star+1;
            }else return false;
        }
        
        while(pp < p.length() && p.charAt(pp) == '*'){
            pp++;
        }
        return pp == p.length();
    }
}
