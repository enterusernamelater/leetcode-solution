package leetcode.conquer.sol.matrix;

import java.util.LinkedList;
import java.util.Queue;

/*
 * a bfs solution that first store all lands '1' into a queue
 * then from each land find water pos one level at a time. we the first round finishes we
 * increment the res by 1 meaning we have found a further distance of water '0'
 * until we cant find any water pos then the res is the longest distance of a water to any land. 
 * Time O(m*n) Space O(n*m)
 */
public class AsFarFromLandAsPossible {
	public AsFarFromLandAsPossible() {}
	
    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int n = grid[0].length;
        int m = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] used = new boolean[m][n];
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    used[i][j] = true;
                }
            }
        
        int res = -1;
        int[][] dics = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int k=0;k<size;k++){
                int[] pos = queue.poll();
                for(int[] dic : dics){
                    int i = pos[0] + dic[0];
                    int j = pos[1] + dic[1];
                    if(i<0 || i > n-1 || j < 0 || j > m-1 || used[i][j]) continue;
                    used[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
            res++;
        }
        
        return res <=0? -1 : res;
    }
}
