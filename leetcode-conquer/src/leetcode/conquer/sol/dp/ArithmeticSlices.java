package leetcode.conquer.sol.dp;

/*
 * explanation as the following:
i) We need minimum 3 indices to make arithmetic progression,
ii) So start at index 2, see if we got two diffs same, so we get a current 1 arith sequence
iii) At any index i, if we see it forms arith seq with former two, that means running (curr) sequence gets extended upto this index, at the same time we get one more sequence (the three numbers ending at i), so curr++. Any time this happens, add the curr value to total sum.
iv) Any time we find ith index does not form arith seq, make currently running no of seqs to zero.

the reason why we do a + dp[i-1] is because for example 1 2 3 4 5 and the current dp index is 5
the dp[5] will equal to 3 4 5 + 2 3 4 5 + 1 2 3 4 5, in here the 12345 is the '1 +' and 3 4 5, 2 3 4 5 is obtained from dp[i-1]
note that dp[i-1] returns 123, 1234 which is the same 345, 2345 above, meaning the number of Arithmetic slices in 2,3,4,5 in the same as the
number of arithmetic slices in 1, 2, 3, 4.  this is why we + dp[i-1]

Time O(n), Space O(n)
 */
public class ArithmeticSlices {
	public ArithmeticSlices() {}
	
    public int numberOfArithmeticSlices(int[] arr) {
        if(arr.length == 0) return 0;
        
        int[] dp = new int[arr.length];
        int res = 0;
        for(int i=2; i<arr.length;i++){
            if(arr[i] - arr[i-1] == arr[i-1] - arr[i-2]){
                dp[i] = 1 + dp[i-1];
                res+=dp[i];
            }
        }
        
        return res;
    }
}
