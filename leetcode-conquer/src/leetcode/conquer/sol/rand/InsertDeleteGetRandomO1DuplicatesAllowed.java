package leetcode.conquer.sol.rand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * same approach as the InsertDeleteGetRandomO1 but the map will be storing a list of indexes
 * so when remove we first get the last index for the remove val, then replace the index with the list's last val
 * then we update the list's last val's indexes indexOf(list.size()-1) to the about to remove val's index.
 * then we remove the remove val's index from its index list and remove the last index from the total list
 * now if the remove val's index list is empty we know we have no more of this val. we remvoe the val from the map.
 * Time O(n) Space O(n)
 */
public class InsertDeleteGetRandomO1DuplicatesAllowed {

	 /** Initialize your data structure here. */
    Map<Integer,List<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    public InsertDeleteGetRandomO1DuplicatesAllowed() { }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        List<Integer> indexes = map.getOrDefault(val, new ArrayList<>());
        indexes.add(list.size());
        map.putIfAbsent(val,indexes);
        list.add(val);
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        List<Integer> indexes = map.get(val);
        //remove index
        int index1 = indexes.get(indexes.size()-1);
        
        //replace value
        int replace = list.get(list.size()-1);
        
        list.set(index1,replace);
        List<Integer> replaceindexes = map.get(replace);
        
        replaceindexes.set(replaceindexes.indexOf(list.size()-1), index1);
        //remove the val's index needs to happen after this replace val' index is updated
        //this is because we need to handle a speical case where remove val and replace val are the same.
        //we they are the same, replaceindexes and indexes are basically the same reference array.
        indexes.remove(indexes.size()-1);
        list.remove(list.size()-1);
        
        if(indexes.isEmpty()) map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
