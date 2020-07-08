package leetcode.conquer.sol.recursion;

/*
 * basically finding the combination of numbers can be formed from 0,1,6,8,9
 * and make sure handle overflow
 * and once number found to be less than n find the reverse by using the reverse map and make sure they are different
 */
public class ConfusingNumberII {
	public ConfusingNumberII() {}
	
    int[] combos = {0,1,6,8,9};
    int[] reverseMap = {0,1,-1,-1,-1,-1,9,-1,8,6};
    int res = 0;
    public int confusingNumberII(int N) {
        dfs(N,0);
        return res;
    }
    
    private void dfs(int n, int current){
        if(current <= n){
            int revert = reverse(current);
            if(current != revert) res++;
        }
        
        for(int digit : combos){
            if(current == 0 && digit == 0) continue;
            long tmp = current*10l + digit;
            if(tmp > n) return;
            dfs(n,current*10 + digit);
        }
        
    }
    
    private int reverse(int num){
        int a = 0;
        while(num>0){
            int single = num%10;
            a = a*10 + reverseMap[single];
            num/=10;
        }
        return a;
    }
}
