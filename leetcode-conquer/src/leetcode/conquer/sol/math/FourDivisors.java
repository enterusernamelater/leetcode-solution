package leetcode.conquer.sol.math;

//this solution is a reference to this solution https://www.geeksforgeeks.org/count-divisors-n-on13/
//Time O(n^1/3)
public class FourDivisors {
	public FourDivisors() {}
	
    public int sumFourDivisors(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int n : nums){
            int count = 0;
            int sum = 0;
            for(int i=1;i<=Math.sqrt(n);i++){
                if(n%i == 0){
                    if(n/i == i){ // only one divisor because n/i and i are the same
                        count++;
                        sum+=i;
                    }
                    else{ //two divisors and n/i will not re-appear because of the i<=Math.sqrt(n) condition
                        count+=2;
                        sum+=i;
                        sum+=n/i;
                    }
                }
                if(count > 4){
                    count = 0;
                    sum = 0;
                    break;
                }
            }
            if(count == 4) res+=sum;
        }
        
        return res;
    }
}
