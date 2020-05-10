package leetcode.conquer.sol.string;

/*
 * since we allow one skip, once a error found we try a skip on both side
 * if still error then we fail it
 */
public class ValidPalindromeII {
	public ValidPalindromeII() {}
	
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int l=0;
        int r=s.length()-1;
        
        while(l<=r && s.charAt(l) == s.charAt(r)){
            l++; r--;
        }
        
        if(l>=r) return true;
                
        return check(l+1,r,s) || check(l,r-1,s);
    }
    
    private boolean check(int l, int r, String s){
        while(l<=r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else return false;
        }
        
        return true;
    }
}
