package leetcode.conquer.sol.dp;

/*
 * this link says it all..:
 * https://www.youtube.com/watch?v=deh7UpSRaEY
 * 
 * with a helpful comment during my time of doubt:
 * The 3rd post needs to be different than the 2nd, so any color except 1( The 2nd Color).  
 * K - 1, means all the colors except the second, or all the colors except the previous color.  
 * At first I thought it would be K-2 for the 3rd post, but the 1st and 3rd colors do not have to be different.
 * 
 * Time O(n) Spance O(1)
 */
public class PaintFence {
	public PaintFence() {}
	
	 public int numWays(int n, int k) {
	        if(n == 0)
	            return 0;
	        
	        if(n == 1)
	            return k;
	        
	        int same = k; //k*1 same in first two posts
	        int diff = k*(k-1); // different in first two posts
	        
	        for(int i=3;i<=n;i++){
	            int tmp = diff;
	            /*
	             * when calculating different colors between current post and previous post
	             * the same color dp val can be diff by times k-1
	             * the diff color dp val can also be diff by times k-1
	             * when calculating same colors dp val between current post and previous post
	             * only when to do this is by making the diff dp val the same which means apply the same color
	             * so the diff dp val comes the same 
	             * the above dp logic continues.
	             */
	            diff = (same+diff)*(k-1);
	            same = tmp;
	        }
	        
	        return diff+same;
	    }
}
