package leetcode.conquer.sol.string;

/*
 * use ascii to findout the differences between two strings.
 * Time o(n)
 * Space o(n)
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
	public MinimumNumberOfStepsToMakeTwoStringsAnagram() {}
	
    public int minSteps(String s, String t) {
        if(s.equals(t)) return 0;
        int[] arr = new int[26];
        for(char c : s.toCharArray())
            arr[c-'a']++;
        
        for(char c : t.toCharArray())
            arr[c-'a']--;
        
        int count = 0;
        for(int i : arr)
            if(i>=1) count+=i;
        
        return count;
    }
}
