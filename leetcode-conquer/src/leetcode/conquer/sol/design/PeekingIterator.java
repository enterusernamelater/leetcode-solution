package leetcode.conquer.sol.design;

import java.util.Iterator;

/*
 * The idea is to use a peek pointer along with the iterator 
 * peek pointer and next point always go together, when peek return peek
 * when next when return peek but update peek with new next
 * Time O(1) Space O(N)
 */
public class PeekingIterator implements Iterator<Integer>{
    private Iterator<Integer> iterator;
    private Integer peek;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
        if(this.iterator.hasNext()) peek = this.iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int res = peek;
        peek = iterator.hasNext()? iterator.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}
}
