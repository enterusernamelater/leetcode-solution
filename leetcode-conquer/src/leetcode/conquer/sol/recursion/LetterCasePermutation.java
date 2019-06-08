package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * time o(2^n)
 * space o(2^n)
 * https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation
*/
public class LetterCasePermutation {
	public LetterCasePermutation() {}
	
    private List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        helper(s.toCharArray(),"",0);
        return res;
    }
    
    private void helper(char[] arr, String cur, int start){
        if(cur.length()==arr.length){
            res.add(cur);
            return;
        }
        
        if(!Character.isLetter(arr[start])){
            helper(arr,cur+arr[start],start+1);
            return;
        }
        
        char c = Character.toUpperCase(arr[start]);
        helper(arr,cur+c,start+1);
        c = Character.toLowerCase(arr[start]);
        helper(arr,cur+c,start+1);
    }
}
