package leetcode.conquer.sol.recursion;

/*
 * time complexity o(n!) as of permustation
 * space complexity o(n)
 * solution referring to the leetcode solution
 * this is a backtracking solution
 */
public class BeautifulArrangement {
	
    private int res = 0;
    
    public int countArrangement(int N) {
        boolean[] used = new boolean[N+1];
        helper(N,1,used);
        return res;
    }
    
    private void helper(int n, int pos, boolean[] used){
        if(pos >n){
            res++;
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(!used[i] && (i%pos == 0 || pos%i == 0)){
                used[i] = true;
                helper(n,pos+1,used);
                used[i] = false;
            }
        }
    }
}
