package leetcode.conquer.sol.recursion;

import java.util.List;

import leetcode.conquer.sol.recursion.util.NestedInteger;

/*
 * this is another dfs sol, very similar solution to the first sol
 * exception we need to find the height because we now backtrack the level in a reverse order
 * as the farest list is the first level and the surface has the highest level. 
 * so every level we call recursively we -1
 * time o(n), n being the size of the list space is constant. meaning o(1) as we dont use any spaces here
 */
public class NestedListWeightSumII {
	
	public NestedListWeightSumII() {}
	
    private int height = Integer.MIN_VALUE;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.isEmpty()) return 0;
        height(nestedList,0);
        return helper(nestedList, height);
    }
    
    private int helper(List<NestedInteger> nestedList, int cur){
        if(cur == 0) return 0;
        int sum = 0;
        
        for(NestedInteger val : nestedList){
            if(val.getInteger() != null){
                sum += cur * val.getInteger();
            }else{
                sum += helper(val.getList(),cur-1);
            }
        }
        return sum;
    }
    
    private void height(List<NestedInteger> nestedList, int cur){
        this.height = Math.max(height,cur);
        
        for(NestedInteger val : nestedList){
            height(val.getList(), cur+1);
        }
    }
}
