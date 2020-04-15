package leetcode.conquer.sol.design;

import java.util.PriorityQueue;

/*
 * using two heaps 
 * heap s is the first half sorted desc 
 * heap l is the second half sorted asc
 * heap s is always the larger heap when in the odd size
 * when finding medium on odd size return heap s.peek
 * when finding medium on even size return (s.peek() + l.peek())/2.0
 */
public class FindMedianFromDataStream {
	public FindMedianFromDataStream() {}
	
    PriorityQueue<Integer> s = new PriorityQueue<>((a,b) -> (b-a));
    PriorityQueue<Integer> l = new PriorityQueue<>();
    
    public void addNum(int num) {
        if(s.isEmpty() || s.peek() >= num) s.offer(num);
        else l.offer(num);
        
        //only throw to the second half we the first half is greater than the second half by two
        //this way the first half is always the size greatest and no npe when finding the medium on the s.peek()
        if(s.size() > l.size()+1) l.offer(s.poll());
        else if(l.size() > s.size()) s.offer(l.poll());
    }
    
    public double findMedian() {
        return s.size() == l.size()? (s.peek() + l.peek())/2.0 : s.peek();
    }
}
