package leetcode.conquer.sol.math;

/*
 * For this question we count how many primes and then we do permutation calculatiopn on the prime ones and non-prime ones, 
 * this is bascially a math problem and we have to use long and mod 10^9 -7. Stupid question because of the stupid overflow god.
 * bascially the formula for this question is p! * np! the p is the prime numbers count and np is the non prime numbers count. ! is the factorial
 * 
 * Time O(n)
 * Space O(n)
 */
public class PrimeArrangements {
    private int mod = 1000000007;
    
    public PrimeArrangements() {}
    
    public int numPrimeArrangements(int n) {
        if(n==0) return 0;
        int primes = countPrime(n);
        int left = n-primes;
        
        //fews things to note here, the i cant end/start with 0. 
        long resPrime = 1;
        for(int i=1;i<=primes;i++) {
            resPrime *=i;
            resPrime %= mod;
        }
        long leftRes = 1;
        for(int i=1;i<=left;i++){
            leftRes*=i;
            leftRes %=mod;
        }
        long res = resPrime * leftRes;
        int intRes = (int) (res % mod);
        return intRes;
    }
    
    private int countPrime(int n){
        int res =0;
        boolean[] notPrime = new boolean[n+1];
        for(int i=2; i<=n;i++){
            if(notPrime[i]) continue;
            res++;
            for(int j=2; i*j<=n; j++){
                notPrime[i*j] = true;
            }
        }
        
        return res;
    }
}
