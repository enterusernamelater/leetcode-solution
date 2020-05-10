package leetcode.conquer.sol.recursion;

/*
 * this is a backtracking solution assumming the first player will win and each recursion turn the player alternantes
 * if the first player starts a valid pick (s.charAt(i-1) == '+' && s.charAt(i) ) and the second player came back from the backtracking
 * can win from the remaining string we know the first player has the sure win 
 * Time O(n^2) since we need to check all "++" combinations
 * Space constant with recursion stack
 */
public class FlipGameII {
	public FlipGameII() {}
	
    public boolean canWin(String s) {
        for(int i=1;i<s.length();i++){
            //starting with the player pick and make sure the second player from came back lost
            //each recursion here the starting player alternates
            if(s.charAt(i-1) == '+' && s.charAt(i) == '+' && !canWin(s.substring(0,i-1) +"--" + s.substring(i+1,s.length()))) return true;
        
        }
        
        return false;
    }
}
