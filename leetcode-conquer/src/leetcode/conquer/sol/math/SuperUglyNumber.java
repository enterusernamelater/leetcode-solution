package leetcode.conquer.sol.math;

import java.util.Arrays;

/*
 * a same approach as ugly number II 
 * use an arr keep track of each prime number's index. this index is the index in the res list.
 * which guarantees this index in the res list multiply by the current prime number will give u the min val
 * that is not in the res list.
 * see comment below too
 * Time(n*primes.length) space o(n+primes.length)
 */
public class SuperUglyNumber {
	public SuperUglyNumber() {}
	
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==0 || primes==null || primes.length ==0) return 0;
        
        //need an arr index to keep all primes index for the res arr
        //they all starts from 0, if a result is found from this prime index 
        //we increment it by one 
        //the index for each prime number corsponds to the res list
        //and represents the MIN value the current prime number can obtain (by multipy the res[idx[j]])
        //that is NOT in the res list, which means is not a duplicate
        int[] idx = new int[primes.length];
        //a result array 
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        //of course the first prime is 1
        res[0] = 1; 
        
        for(int i=0;i<n;i++){
            for(int j=0;j<primes.length;j++){
                res[i] = Math.min(res[i],res[idx[j]] * primes[j]);
            }
            
            for(int j=0;j<primes.length;j++){
                if(res[idx[j]] * primes[j] == res[i]) idx[j]++;
            }
        }
        
        return res[n-1];
    }
}
