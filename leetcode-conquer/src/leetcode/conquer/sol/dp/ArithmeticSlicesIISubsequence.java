package leetcode.conquer.sol.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * a dp solution that first store all the indexs for all values in the list becuase of the dup values.
 * then calculated required val through dp pairs using equation 2*arr[j]-arr[i]
 * this will return you with the previous val that will fit into pair arr[j] and arr[i]
 * to form a arithmetic sequence. then the logic is based on the previous question ArithmeticSlices where
 * +1 is the total sequence from the length and add dp[j][k] where j and k(previous val index) is the previous pair 
 * before j and i. like the previous sol the total ArithmeticSlices of the current pair j i is its self the total length plus the total
 * ArithmeticSlices of the previous pair.
 * link:
 * https://www.youtube.com/watch?v=RaNUycEtGAk
 * Time O(n^2) space O(n^2)
 */
public class ArithmeticSlicesIISubsequence {
	public ArithmeticSlicesIISubsequence() {}
	
	public int numberOfArithmeticSlices(int[] arr) {
        if(arr.length == 0) return 0;
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        Map<Long, List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.putIfAbsent(Long.valueOf(arr[i]), new ArrayList<>());
            map.get(Long.valueOf(arr[i])).add(i);
        }
        
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                Long target = 2*Long.valueOf(arr[j])-arr[i];
                if(map.containsKey(target)){
                    for(int k : map.get(target)){
                        if(k<j){
                            dp[i][j] += dp[j][k]+1;
                        }
                    }
                    res+=dp[i][j];
                }    
            }
        }
        
        return res;
    }
}
