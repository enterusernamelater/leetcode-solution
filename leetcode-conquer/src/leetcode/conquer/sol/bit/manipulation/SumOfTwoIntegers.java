package leetcode.conquer.sol.bit.manipulation;

/*
 * see comment to understand on to use bit operation to perform addition 
 * https://www.youtube.com/watch?v=qq64FrA2UXQ
 * Time o(n) space o(n)
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        //& will give you the pos that will need to carry
        //xor will perform as addition
        
        while(b!=0){
            int carry = a & b;
            a ^=b;
            b = carry << 1;
        }
        
        return a;
    }
}
