package leetcode.conquer.sol.string;

import java.util.HashMap;
import java.util.Map;

/*
 * sliding window with a map that counts the total repeated char counts
 * when map exceed k then we start de-sizing the sliding window until map size is equal to k 
 * while doing above using a two pointers i to j that always track the distance of the substring
 * in the end we return the max
 * 
 * Time O(n)
 * Space O(n)
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
	public LongestSubstringWithAtMostKDistinctCharacters() {}
	
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        
        int res = 0;
        int i=0;
        for(int j=0; j<chs.length; j++){
            map.put(chs[j], map.getOrDefault(chs[j],0)+1);
            while(map.size()>k){
                int count = map.get(chs[i])-1;
                if(count == 0) map.remove(chs[i]);
                else map.put(chs[i],count);
                i++;
            }
            res=Math.max(res, j-i+1);
        }
        
        return res;
    }
}
