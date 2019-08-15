package leetcode.conquer.sol.bit.manipulation;

/*
 * we first convert each string from the given arr into a 32 bit binary
 * by using inclusive or operator.
 * then we loop each pair of string and & each string's 32 bit binary serial to see if equals 0
 * if 0 meaning no common characters. 
 * 
 * Time O(n^2) Space O(N)
 */
public class MaximumProductOfWordLengths {
	
	public MaximumProductOfWordLengths() {}
	
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        
        int[] serial = new int[words.length];
        
        for(int i=0; i<words.length; i++){
            char[] arr = words[i].toCharArray();
            for(char c : arr)  
                serial[i] |= 1<<(c-'a'); //Transform each word into a 32 bit binary
        }
        
        int res = 0;
        for(int i=0; i<words.length; i++){
            for(int j = i+1; j<words.length; j++){
                //use the serial we build and do & to see if is equal to 0 to know if any common char exists
                if((serial[i] & serial[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        
        return res;
    }
}
