package leetcode.conquer.sol.tree;

/*
 * this solution referring to link: 
 * https://www.youtube.com/watch?v=ZAq5BoTes8o
 * for every i from 1...n we have a function which determines how many unique bst possible
 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
 * time o(n^2) space O(n)
 * the detailed explanation on how the formula is formed is through this link
 * https://www.youtube.com/watch?v=GgP75HAvrlY
 */
public class UniqueBinarySearchTrees {
	public UniqueBinarySearchTrees() {}
	
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
