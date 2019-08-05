package leetcode.conquer.sol.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * this is a combination solution where order of the solution doesn't matter
 * so we use a map to skip
 * the key point to under this solution is to understand the min-max algorithm
 * link: https://www.youtube.com/watch?v=l-hh51ncgDI
 * the logic behind is this. assuming player 1 start at first layer of the tree, picking the first number
 * in the second layer if the second player cannot win by choosing any numbers after the first pick from player 1 (first layer node)
 * first player then guarantee a win. 
 * each layer of the tree two players choose to win, if the second player wins the results returns to the player 1's layer
 * which is the precious layer and the player 1 continues with his pick. vice-versa player 1 wins return result to player 2, player 2 continues 
 * his pick.
 * this recursion logic continues until we reach to the top. in the second layer. if second player ran out of option to choose from to win (meaning 
 * the third layer- the 1 player's turn, wins)
 * the first player to win.
 * in the first layer. if first player ran out of option to choose from to win, then the second player wins. (meaning the second layer keeps returning true)
 * Since this is a combination question
 * the Time Complexity is O(2^n) space is O(n)
 */
public class CanIWin {
	public CanIWin() {}
	
    private Map<String , Boolean> map;
    private boolean[] used;
    private int max;
    
    public boolean canIWin(int max, int sum) {
        if(max > sum) return true;
        if(((1+max)*max)/2 < sum) return false;
        
        this.map = new HashMap<>();
        this.used = new boolean[max+1];
        this.max = max;
        return helper(sum);
    }
    
    private boolean helper(int currSum){
        //this player lost
        if(currSum <= 0) return false;
        
        String key = Arrays.toString(used);
        
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        for(int i=1; i<=max ; i++){
            if(used[i]) continue;
            used[i] = true;
            if(!helper(currSum - i)){
                //this player win
                map.put(key,true);
                used[i] = false;
                return true;
            }
            used[i] = false;
        }
        map.put(key,false);
        return false;
    }
}
