package leetcode.conquer.sol.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * first find the max on each col
 * then find the min on the row while storing the index col
 * once min row found check if the index on the col of the min row is the same
 * as the max col
 * Time O(n*m)
 * Space O(n)
 */
public class LuckyNumbersInAMatrix {
	public LuckyNumbersInAMatrix() {}
	
    public List<Integer> luckyNumbers (int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        int n = matrix[0].length;
        int m = matrix.length;
        int[] colMax = new int[n];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<m;j++){
                max = Math.max(matrix[j][i],max);
            }
            colMax[i]=max;
        }
        
        for(int i=0;i<m;i++){
                int index = 0;
                int min = matrix[i][0];
            for(int j=0;j<n;j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    index = j;
                }
            }
            if(colMax[index] == min){
                res.add(min);
            }
        }
        return res;
    }
}
