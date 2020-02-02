
package leetcode.conquer.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move"]
[[3,3,[[0,1],[0,2],[1,2],[2,2],[2,1],[2,0],[1,0]]],["R"],["R"],["D"],["D"],["L"],["L"],["U"],["U"],["R"],["R"],["D"],["D"],["L"],["L"],["U"],["R"],["U"],["L"],["D"]]
 */
public class Main {
	public static void main(String[] argv) 
    { 

       
        int[] mat = new int[] {3,3,3,3,5,5,5,2,2,7};
        Main sol = new Main();
        sol.minSetSize(mat);
    } 
	
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]==b[1]? a[0] - b[0] : a[1] - b[1]);
        for(int i=0;i<m;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    break;
                }
                count++;
            }
            count++;
            q.offer(new int[]{i,count});
        }
        
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = q.poll()[0];
        }
        
        return res;
    }
    
    public int minSetSize(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        TreeMap<Integer,Integer> map = new TreeMap<>((a,b) -> b-a);
        
        for(int val : arr) map.put(val,map.getOrDefault(val,0)+1);
        
        int res = 1;
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            count+=entry.getValue();
            if(count*2 < n) res++;
            else
                break;
        }
            
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return res;
    }
}
