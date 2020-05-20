package leetcode.conquer.sol.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * check the property is now and previous match
 * Time O(nm)
 */
public class ToeplitzMatrix {
	public ToeplitzMatrix() {}
	
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i-1>=0 && j-1>=0 && matrix[i-1][j-1] != matrix[i][j]) return false;
            }
        }
        
        return true;
    }
    
    public boolean isToeplitzMatrixHashMap(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Set<Integer> set = map.getOrDefault(j-i,new HashSet<>());
                if(set.isEmpty()){
                    set.add(matrix[i][j]);
                }else if(set.add(matrix[i][j])) return false;
                map.putIfAbsent(j-i,set);
            }
        }
        
        return true;
    }
}
