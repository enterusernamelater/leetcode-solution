
package leetcode.conquer.sol.tree;

import java.util.HashMap;
import java.util.Map;

/*
 * This question is a recursive question
 * The idea is to use each number i as root node, 
 * Then the left branch will be what's less than i, 
 * The right branch will be what's larger than i. 
 * The total number of distinct structure is their product. 
 * Thus, sum up the product for all numbers. Use a map to memorize the visited number.
 */
public class UniqueBinarySearchTrees {
	public UniqueBinarySearchTrees() {}
	
    public int numTreesRecursive(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);// empty bst counts as 1
        map.put(1,1);//single node bst counts as 1;
        return helper(map,n);
    }
    
    private int helper(Map<Integer,Integer> map, int n){
        if(map.containsKey(n)) return map.get(n);
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum+=helper(map,i-1) * helper(map,n-i);
        }
        map.put(n,sum);
        return sum;
    }
	
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        for(int i=1;i<=n;i++)
            for(int j=0; j<i;j++)
            	//arr[j] is our previously calculated sub,same as arr[i-j-1]
                arr[i]+=arr[j]*arr[i-j-1];
        
        return arr[n];
    }
}
