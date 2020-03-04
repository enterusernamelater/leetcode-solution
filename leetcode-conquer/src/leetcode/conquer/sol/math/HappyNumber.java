package leetcode.conquer.sol.math;

import java.util.HashSet;
import java.util.Set;

/*
 * In this question you basically check if we have a cycle. a cycle occurs when calculation of the sum of the squares of its digit
 * appears twice in the set and is not 1 then we have a cycle and return false.
 * I would say the complexity is O(n) where n is the number of digits calculated until 1 or cycle
 * space O(n)
 */
public class HappyNumber {
	public HappyNumber() {}
	
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            int sum = 0;
            while(n>0){
                sum += (n%10) * (n%10);
                n/=10;
            }
            if(sum == 1) return true;
            n=sum;
        }
        return false;
    }
}
