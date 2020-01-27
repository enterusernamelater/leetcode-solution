package leetcode.conquer.sol.string;

/*
 * tbh this question is dumb, when a palindrom can only be formed by two different chars. 
 * the result is either 1 or 2. empty returns 0
 * Time O(n) Space constant
 * 
 */
public class RemovePalindromicSubsequences {
	public RemovePalindromicSubsequences() {}
	
    public int removePalindromeSub(String s) {
        if(s == null || s.length() == 0) return 0;
        int l = 0;
        int r = s.length()-1;
        int res = 1;
        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                res++;
                return res;
            }
        }
        return res;
    }
}
