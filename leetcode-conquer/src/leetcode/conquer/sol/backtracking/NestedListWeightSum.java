package leetcode.conquer.sol.backtracking;

import java.util.List;

import leetcode.conquer.sol.backtracking.util.NestedInteger;

/*
 * time o(size of the nestedlist), space is constant
 * simple dfs sol.
 * referring to the questions sol.
 */
public class NestedListWeightSum {
	public NestedListWeightSum() {}
	
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList,1);
    }
    
    private int helper(List<NestedInteger> nestedList, int level){
        int sum =0;
        for(NestedInteger val : nestedList){
            if(val.getInteger() != null){
                sum += val.getInteger() * level;
            }else{
                sum += helper(val.getList(), level+1);
            }
        }
        return sum;
    }
}
