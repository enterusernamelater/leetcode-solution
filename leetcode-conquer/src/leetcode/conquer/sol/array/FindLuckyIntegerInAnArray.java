package leetcode.conquer.sol.array;

import java.util.HashMap;
import java.util.Map;

/*
 * map the key count then finding the key coung that equals the key
 */
public class FindLuckyIntegerInAnArray {
	public FindLuckyIntegerInAnArray() {}
	
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            int count = map.getOrDefault(val,0);
            map.put(val,++count);
        }
        
        int res = -1;
        for(Integer key : map.keySet()){
            if(map.get(key) == key) res = Math.max(res,key);
        }
        return res;
    }
}
