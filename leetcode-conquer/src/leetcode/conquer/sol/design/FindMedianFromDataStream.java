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
	
    PriorityQueue<Integer> high = new PriorityQueue<>((a,b) -> (a-b));
    PriorityQueue<Integer> low = new PriorityQueue<>((a,b) -> (b-a));
    /** initialize your data structure here. */
    
    public void addNum(int num) {
        if(low.isEmpty()){
            low.offer(num);
            return;
        }
        
        if(low.peek()>num){
            low.offer(num);
        }else{
            high.offer(num);
        }
        
        /*
         * allow both side low and high to be one more on the other side only pop if in-balance become greater than 1
         */
        if(low.size()>high.size()+1){
            high.offer(low.poll());
        }else if(high.size() > low.size() + 1){
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if((low.size() +high.size()) % 2 == 0){
            return (double)((low.peek() + high.peek()) / 2.0);
        }else if(low.size()>high.size()){
            return low.peek();
        }else{
            return high.peek();
        }
       
    }
}
