package leetcode.conquer.sol.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * The idea of this solution is to use a set to keep track of the numbers that are used
 * and use a stack to pop any available numbers
 * when release, if the release the number is in the used set we remove from the set and add to the available stack
 * stack or queue both works in this case
 * remove on the set is O(1)
 * Time O(1) on all function
 * Space O(n)
 */
public class DesignPhoneDirectory {
	private Set<Integer> used;
    private Deque<Integer> use;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        this.used = new HashSet<>();
        this.use = new ArrayDeque<>();
        for(int i=0;i<maxNumbers;i++) use.push(i);
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(use.isEmpty()) return -1;
        int res = use.pop();
        used.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
      if(!used.contains(number)) return;
      used.remove(number);
      use.push(number);
    }
}
