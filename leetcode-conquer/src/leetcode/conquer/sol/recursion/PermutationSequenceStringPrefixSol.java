package leetcode.conquer.sol.recursion;

/*
 * no memorization solution.(no map or arr to save val)
 * using string prefix and decrementing the k val until it reaches to 1 and returns the string prefix as ans.
 * time o(n!), space o(n)
 */
public class PermutationSequenceStringPrefixSol {
    private String ans = "";
    private int count = 0;
    public String getPermutation(int n, int k) {
        this.count = k;
        helper(n,new boolean[n+1],"");
        return ans;
    }
    
    private void helper(int n, boolean[] bool, String s){
        if(count==0) return;
        if(s.length()==n){
            if(count==1) ans = s;
            count--;
        }
        
        for(int i=1;i<=n;i++){
            if(bool[i] == true) continue;
            bool[i]=true;
            helper(n,bool,s+i);
            bool[i] = false;
        }
    }
}
