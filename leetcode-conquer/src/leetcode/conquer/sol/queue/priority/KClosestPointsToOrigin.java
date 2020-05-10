package leetcode.conquer.sol.queue.priority;

import java.util.PriorityQueue;

/*
 * use priority queue to sort the points and then return the first k
 */
public class KClosestPointsToOrigin {
	public KClosestPointsToOrigin() {}
	
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
          
          for(int[] val : points){
              q.offer(val);
          }
          
          int[][] res = new int[k][2];
          while(k>0){
              res[k-1] = q.poll();
              k--;
          }
          return res;
      }
}