package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * check out this link: the solution is smart. will explain better than myself lol
 * https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
 * Time O(n) Space O(n)
 */
public class PermutationSequenceStringOnePass {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        factorial[0]=1;
        int sum = 1;
        for(int i=1; i<=n; i++){
            sum *=i;
            factorial[i] = sum;
        }

        List<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++)
            arr.add(i);
        
        k--;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1;i<=n;i++){
            int index = k/factorial[n-i];
            System.out.println(index);
            sb.append(String.valueOf(arr.get(index)));
            arr.remove(index);
            k-=index*factorial[n-i];
        }
        
        return sb.toString();
    }
}
