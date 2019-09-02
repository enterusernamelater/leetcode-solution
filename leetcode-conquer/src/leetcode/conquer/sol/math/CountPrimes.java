package leetcode.conquer.sol.math;

/*
 * assume all primes first and find each numbers multiplier from 2 to n if exists then we mark the non prime to true
 * in the end only the ones that dont have any multiplier fron 2 to n but themself is the winner
 * Time O(n) Space O(n)
 */
public class CountPrimes {
	public CountPrimes() {}
	
    public int countPrimes(int n) {
        //assume all is prime;
        //https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes 算法
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for(int i=2;i<n;i++){
            if(!notPrime[i]){
                res++;
                for(int j =2; j*i < n;j++){
                    notPrime[j*i] = true;
                }
            }
        }
        return res;
    }
}
