package leetcode.conquer.sol.rand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * we use a map that stores the number as the key and its index as the value
 * map is used for checking exits
 * when add, if the map doesn't contain the val we add the val to the map with its corresponding index in the arr list
 * then add the val to the arr list and return to true
 * 
 * when remove in order to achieve o(1)
 * we swap the last elem is the arr with the given val's pos
 * and we update the last elem's value in the map to the new index in the arr
 * we remove the given val in the map.
 * then we remove the given val from the arr's last index because of the swap
 * 
 * when pick randon we simpiliy return a random index's value from the array
 * 
 * link that explains this question:
 * https://www.youtube.com/watch?v=y240Qh9H9uk
 * Time O(n) Space O(n)
 */
public class InsertDeleteGetRandomO1 {
	private List<Integer> list;
	private Map<Integer,Integer> map;

	private Random rand = new Random();
	/** Initialize your data structure here. */
	public InsertDeleteGetRandomO1() {
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(map.containsKey(val)) return false;
		map.put(val,list.size());
		list.add(val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(!map.containsKey(val)) return false;
		//first swap the val with the last element in the arr
		int tmp = list.get(list.size()-1);
		int index = list.indexOf(val);
		list.set(index,tmp);
		list.set(list.size()-1,val);

		//update the last elem's index in map
		map.put(tmp,index);
		//remove the val in map and remove the last one in arr
		map.remove(val);
		list.remove(list.size()-1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}
}
