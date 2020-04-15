package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.List;

/*
 * find a dup the flip and flip back
 * Time O(n)
 * Space constant
 */
public class FlipGame {
	public FlipGame() {}
	
    public List<String> generatePossibleNextMoves(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        
        for(int i=1;i<arr.length;i++){
            if(arr[i] == arr[i-1] && arr[i] == '+'){
                arr[i]='-';arr[i-1]='-';
                list.add(String.valueOf(arr));
                arr[i]='+';arr[i-1]='+';
            }
        }
        
        return list;
    }
}
