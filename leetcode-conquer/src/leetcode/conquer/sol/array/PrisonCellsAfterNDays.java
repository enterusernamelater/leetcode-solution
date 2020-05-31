package leetcode.conquer.sol.array;
import java.util.*;

/*
 * we know there are repeating cells after certain period of time
 * so we repeat detected we mod n and take the reminder as we only care about wats left to change
 * https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14
 */
public class PrisonCellsAfterNDays {
	public PrisonCellsAfterNDays() {}
	
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String,Integer> map = new HashMap<>();
        while(N>0){
        	//Arrays.toString() as the key
            map.put(Arrays.toString(cells),N--);
            int[] copy = new int[8];
            for(int j=1;j<7;j++){
                if(cells[j-1] == cells[j+1]) copy[j] = 1;
                else copy[j] = 0;
            }
            cells = copy;
            //when a repeat cycle detected we need to only care about the changes in the remainder. 
            if(map.containsKey(Arrays.toString(cells))){
                N%=map.get(Arrays.toString(cells)) - N;
            }
        }   
        return cells;
    }
}
