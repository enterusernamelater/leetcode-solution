package leetcode.conquer.sol.recursion;

/*
 * see comments below for explaination
 * link that explains the question very well:
 * https://www.youtube.com/watch?v=HHiHno66j40
 * Time O(n^2) as this is a matrix n*n Space constant
 */
public class FriendCircles {
	public FriendCircles() {}
	
	public int findCircleNum(int[][] M) {
		if(M == null || M.length == 0) return 0;

		//total friends
		int n = M.length;

		//dfs on each person and find their friends and remove them
		//remove them by un-friend himself meaning M[i][i] = 0;
		int res = 0;
		for(int i=0;i<n;i++){
			if(M[i][i] == 0) continue;
			res++;
			dfs(M,i,n);
		}

		return res;
	}

	private void dfs(int[][] M, int curr, int n){
		//if the person that is checking is already removed then just return
		if(M[curr][curr] == 0) return;
		
		//marking the current person as visited by un-friend himself
		M[curr][curr] = 0;
		for(int i=0;i<n;i++){
			//if the curr person has a friend i  == 1 we dfs on that friend 
			//in the dfs if the friend is not removed we will first remove him
			if(M[curr][i] == 1){
				dfs(M,i,n);
			}
		}
	}
}
