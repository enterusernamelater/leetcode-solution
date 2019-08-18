package leetcode.conquer.sol.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * we first keep three index for prime 2,3,5, and a result arr start with 0 index = 1;
 * the prime indexs points to the result arr. the starting prime indexes are 0.
 * each loop before arr.size hits n, we multiply each prime number to its corresponding index
 * in the res arr. and we pick the min among them and add to the res arr to maintain a sorted res list from small to large
 * we then increment min result's prime number index in the res arr to maintain a small - large res list. 
 * 
 * Time O(n) Space constant
 */
public class UglyNumberII {
	
	public UglyNumberII() {}
	
    static List<Integer> arr = new ArrayList<>(Arrays.asList(1));
    static int i1 = 0;
    static int i2 = 0;
    static int i3 = 0;
    
    public int nthUglyNumber(int n) {
        while(arr.size()<n){
            int num1 = arr.get(i1)*2;
            int num2 = arr.get(i2)*3;
            int num3 = arr.get(i3)*5;
            int minNum = Math.min(num1,Math.min(num2,num3));
            if(minNum == num1) i1++;
            if(minNum == num2) i2++;
            if(minNum == num3) i3++;
            
            arr.add(minNum);
        }
        return arr.get(n-1);
    }
}
