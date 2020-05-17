package leetcode.conquer.sol.tree.map;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
 * this solution uses the tree map to sort and store each interval's starting point
 * so we a new val is added we first call lowerkey and higherkey to find out the starting intervals before and after the val
 * we merge val if val can connect to the one of the interval or both. 
 * when merging both we have to remove the higher key interval because the higherkey interval no longer exists 
 * when merging into only the higherkey interval we have to remove the old higherkey interval as well
 * because the val is now the new starting point
 * 
 * note the floor returns less and equal, ceiling return greater or equal
 * Time O(nlog(n))
 * Space O(n)
 * 
 */
public class DataStreamAsDisjointIntervals {
	
	 /** Initialize your data structure here. */
    //the key is the starting of the interval
    TreeMap<Integer,int[]> map = new TreeMap<>();
    public DataStreamAsDisjointIntervals() {}
    
    public void addNum(int val) {
        if(map.containsKey(val)) return;
        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);
        
        if(l!= null & h!= null && map.get(l)[1]+1 == val && val+1 == h){
            map.get(l)[1] = map.get(h)[1];
            map.remove(h);
        }else if(l != null && map.get(l)[1]+1 >= val){
            map.get(l)[1] = Math.max(val,map.get(l)[1]);
        }else if(h != null && map.get(h)[0]-1 == val){
            map.put(val,new int[]{val,map.get(h)[1]});
            map.remove(h);
        }else{
            map.put(val,new int[]{val,val});
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>(map.values());
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
