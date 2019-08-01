package leetcode.conquer.sol.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * there is really no point explain this I guess.
 * a pretty straight forward sol that follows the path of spiral.
 * Linked solution vid:
 * https://www.youtube.com/watch?v=dfGhf-Ko0L4
 * Time O(h*w)
 * Space is constant
 */
public class SpiralMatrix {
	public SpiralMatrix() {}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        
        while(left<right && top < bottom){
            for(int i=left;i<right;i++) res.add(matrix[top][i]);
            for(int i=top;i<bottom;i++) res.add(matrix[i][right]);
            for(int i=right;i>left;i--) res.add(matrix[bottom][i]);
            for(int i=bottom;i>top;i--) res.add(matrix[i][left]);
            left++;
            right--;
            top++;
            bottom--;
        }
        
        if(left == right){
            for(int i=top;i<=bottom;i++) res.add(matrix[i][right]);
        }else if(top == bottom){
            for(int i=left;i<=right;i++) res.add(matrix[bottom][i]);
        }
        return res;
	}
}
