package leetcode.conquer.sol.string;

/*
 * first the lsb is added to the carry as a val
 * if the val is 1, we know is odd so we add a carry to 1 (1+1 creates a carry) and add a step + 1 because of making the number even
 * if the val is 2 we know the current number is even so we skip the adding step+1 above but we update the carry to 1
 * then add step + 1 again as now we are removing this lsb. 
 * special case handle when the msb is 1 without carry we return res, other wise we add step + 1 as because msb + carry results '10'
 * additional step requires to remove 0;
 * 
 * Time O(n)
 * Space constant
 */

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
	public NumberOfStepsToReduceANumberInBinaryRepresentationToOne() {}
	
    public int numSteps(String s) {
        if(s == null || s.length() == 0) return 0;
        int carry = 0;
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i=arr.length-1;i>0;i--){
            int val = carry + (arr[i] - '0');
            if(val == 2) carry=1;

            if(val == 1){
                carry = 1;
                res++;
            }
            res++;
        }
        
        return res;
    }
}
