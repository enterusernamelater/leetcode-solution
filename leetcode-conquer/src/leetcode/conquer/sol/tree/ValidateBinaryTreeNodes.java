package leetcode.conquer.sol.tree;

import java.util.HashMap;
import java.util.Map;

/*
 * see comment
 * Time O(n)
 * Space O(n)
 */
public class ValidateBinaryTreeNodes {
	public ValidateBinaryTreeNodes() {}
	
    public boolean validateBinaryTreeNodes(int n, int[] l, int[] r) {
        //child to parent map
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i=0;i<n;i++){
        	/*
        	 * check if the children is pointing to any parent if is not -1
        	 * check if the children are the same
        	 * check if the current parent if not added to the child to the parent map from the previous 
        	 * any condition meet above return false
        	 */
        
            if((l[i]<= i && l[i] != -1) || (r[i] <= i && r[i] != -1) || (l[i] == r[i] && l[i] != -1) || !map.containsKey(i)) return false;
            
            //if child is already in the map, then check if this child has two parent if so return false
            if(map.containsKey(l[i]) && map.get(l[i]) != i) return false;
            if(map.containsKey(r[i]) && map.get(r[i]) != i) return false;
            
            
            //add child and the parent to the map
            if(l[i] != -1) map.put(l[i],i);
            if(r[i] != -1) map.put(r[i],i);
            
        }
        
        return true;
    }
}
