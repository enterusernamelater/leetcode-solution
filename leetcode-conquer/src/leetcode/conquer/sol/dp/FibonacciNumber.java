package leetcode.conquer.sol.dp;

/*
 * a very similar solution to climbing stars
 * time O(n) space O(1)
 */
public class FibonacciNumber {
    public int fib(int n) {
        if(n<=0) return 0;
        int cur =1;
        int prev = 0;
        
        for(int i=2;i<=n;i++){
            int tmp = cur;
            cur = cur+prev;
            prev = tmp;
        }
        return cur;
    }
}
