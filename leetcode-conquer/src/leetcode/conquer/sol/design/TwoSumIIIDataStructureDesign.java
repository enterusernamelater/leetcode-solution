package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * The idea is store all numbers into a list and a map
 * the list only has unique numbers and the map keeps track the number and its count
 * when finding a two sum, first we get the compliment, and check if the compliment is the same as i
 * if so then compliment/i must be duplicate in the list otherwise can't form the two sum
 * if compliment and i are not equal simply check if map contains the compliment. if so return true
 * otherwise return false
 * Time O(n) on find O(1) on add
 * Space O(n)
 */
public class TwoSumIIIDataStructureDesign {
	
    private List<Integer> list;
    private Map<Integer,Integer> map;
    /** Initialize your data structure here. */
    public TwoSumIIIDataStructureDesign() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number))
            map.put(number, map.get(number)+1);
        else{
            map.put(number,1);
            list.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i : list){
            int comp = value - i;
            if(comp == i && map.get(comp)>1 || comp != i && map.containsKey(comp)) return true;
        }
        
        return false;
    }
}
