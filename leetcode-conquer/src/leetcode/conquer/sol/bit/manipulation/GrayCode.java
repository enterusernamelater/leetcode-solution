package leetcode.conquer.sol.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

/*
 * the formula is the key G(i) = i^ (i/2)
 * Time O(n) space the return lis o(n)
 */
public class GrayCode {
    //The idea is simple. G(i) = i^ (i/2).
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        //the 1<<n will produce the total result size of the given n
        //based on the binary, 3 bits for example will give a total of 2^3 result
        //so we shift 1, 3 times to the left
        for(int i=0;i<1<<n;i++)
            res.add(i ^ (i >> 1));
        
        return res;          
    }
}
