package leetcode.conquer.sol.rand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * we use two ds to track our data, first is an list with int[]
 * int[0] is the val, int[1] is the val's pos in the map's list
 * the map's key is the val, the val is the pos of the val in the arr.
 * when add, we add the val to the map along with the val's pos in the arr 
 * we also add val's map pos into val's int[1]
 * 
 * when remove 
 * we swap the remove val with the last one just like the previous question
 * remove arr's last one
 * set the swapped last elem's map pos index(it's int[1]) from the last to the remove val's index
 * this has to happen before the remove below see comment why
 * remove the remove val's map pos (the last one)
 * 
 * return ran pos is the same as the previous with the only difference being once the random result found
 * we return the first index [0] for its val.
 * 
 * link that explained this question very well:
 * https://www.youtube.com/watch?v=mRTgft9sBhA
 * Time O(n) Space O(n)
 */
public class InsertDeleteGetRandomO1DuplicatesAllowed {

	List<int[]> arr;
	Map<Integer,List<Integer>> map;

	private Random rand = new Random();
	/** Initialize your data structure here. */
	public InsertDeleteGetRandomO1DuplicatesAllowed() {
		this.arr = new ArrayList<>();
		this.map = new HashMap<>();
	}

	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		boolean res = !map.containsKey(val);
		List<Integer> list = map.getOrDefault(val, new ArrayList<>());
		list.add(arr.size());
		map.putIfAbsent(val,list);
		arr.add(new int[]{val,list.size()-1});
		return res;
	}

	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		if(!map.containsKey(val)) return false;

		int[] last = arr.get(arr.size()-1);
		List<Integer> valIdxs = map.get(val);
		int idx = valIdxs.get(valIdxs.size()-1);

		List<Integer> lastIdxs = map.get(last[0]);

		arr.set(idx, last);
		arr.remove(arr.size()-1);
		//setting the new idx in map's pos of the swapped last element has to happen before the remove
		//because if the remove val happens to be on the last pos of the arr too, then setting the map's value pos later
		//will result array index out of bound simpily because the index in the int[1] has already being removed
		//note in this case both the last and remove val are the same. 

		lastIdxs.set(last[1],idx);

		if(valIdxs.size()>1){
			valIdxs.remove(valIdxs.size()-1);
		}else{
			map.remove(val);
		}

		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return arr.get(rand.nextInt(arr.size()))[0];
	}
}
