package leetcode.conquer.sol.queue.priority;

import java.util.PriorityQueue;

/*
 * priority queue sort question pretty much
 * T: O(nlog(n))
 * S: O(n)
 */
public class TheKWeakestRowsInAMatrix {
	public TheKWeakestRowsInAMatrix() {}
	
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]==b[1]? a[0]-b[0] : a[1]-b[1]);
        for(int i=0;i<m;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    break;
                }
                count++;
            }
            q.offer(new int[]{i,count});
        }
        
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = q.poll()[0];
        }
        
        return res;
    }
}
