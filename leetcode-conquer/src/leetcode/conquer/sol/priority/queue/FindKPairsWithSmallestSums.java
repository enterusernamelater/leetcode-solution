package leetcode.conquer.sol.priority.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * this solution is pretty similar to the topKFrequentElement question.
 * push all combinations to the queue and set sort property in queue
 * the sort property :
 * (a,b) -> (b.get(0) + b.get(1)) - (a.get(0) + a.get(1))
 * and when q size exceed k we pop
 * Time O(n^2) Space O(n)
 */
public class FindKPairsWithSmallestSums {
	public FindKPairsWithSmallestSums() {}
	
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) return new ArrayList<>();
        
        PriorityQueue<List<Integer>> q = new PriorityQueue<>((a,b) -> (b.get(0) + b.get(1)) - (a.get(0) + a.get(1)));
        List<List<Integer>> res = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();
        
        for(int i : nums1)
            for(int j : nums2)
                arr.add(new ArrayList<>(Arrays.asList(i,j)));  
        
        for(List<Integer> list : arr){
            q.offer(list);
            if(q.size() > k) q.poll();
        }
        
        while(!q.isEmpty()) res.add(0,q.poll());
        
        return res;
    }
}
