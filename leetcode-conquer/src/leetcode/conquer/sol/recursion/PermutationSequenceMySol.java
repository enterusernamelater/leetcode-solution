package leetcode.conquer.sol.recursion;

/*
 * simple permutation solution
 * Time O(n!) Space O(n)
 */
public class PermutationSequenceMySol {
    private boolean[] used;
    private int n;
    private int k;
    
    public String getPermutation(int n, int k) {
        this.used = new boolean[n+1];
        this.n = n;
        this.k = k;
        return helper("");
    }
    
    private String helper(String curr){
        if(curr.length() == n){
            if(k == 1) return curr;
            k--;
            return "";
        }
        
        for(int i=1;i<=n; i++){
            if(used[i]) continue;
            used[i] = true;
            String val = helper(curr+i);
            if(val.length() > 0) return val;
            used[i] = false;
        }
        
        return "";
    }
}
