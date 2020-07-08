package leetcode.conquer.sol.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * convert to one dimension array and bfs from the starting point each bfs we add our step until we reach the end but either moving
 * or ladder
 * two things to keep in mind:
 * 1. You can move to squares with '-1' values. Dont skip them on your BFS, I spent a hour figuring out wtf was happening.
 * 2. Once you landed on a ladder, you cannot move on from the same ladder(yes even the square has another ladder). you have to take a move from the next 1-6 steps from the current index.
 * Time O(nn) Space O(nn)
 */
public class SnakesAndLadders {
	public SnakesAndLadders() {}
	
    public int snakesAndLadders(int[][] board) {
        if(board == null || board.length == 0) return 0;
        
        int n = board.length;
        int[] arr = new int[n*n];
        boolean toggle = false;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(!toggle){
                   arr[(n-i-1)*n+j] = board[i][j]; 
                }else{
                   arr[(n-i-1)*n+(n-j-1)] = board[i][j];
                }
            }
            toggle = !toggle;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n*n];
        visited[0] = true;
        q.offer(0);
        int res = 0;
        while(!q.isEmpty()){
            res++;
            for(int z=q.size();z>0;z--){
                int index= q.poll();
                for(int i=index+1;i<=index+6;i++){
                    if(i == n*n-1 || arr[i] >=n*n) return res;
                    int pos = arr[i] == -1? i : arr[i]-1;    
                    if(visited[pos]) continue;
                    visited[pos] = true;
                    q.offer(pos);
                }
            }
        }
        return -1;
    }
}
