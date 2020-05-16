package leetcode.conquer.sol.recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.conquer.sol.recursion.util.NestedInteger;

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
    
    public int depthSumBFS(List<NestedInteger> list) {
        if(list == null || list.size() == 0) return 0;
        
        Queue<NestedInteger> q = new LinkedList<>();
        int sum =0;
        for(NestedInteger val : list){
             q.offer(val);
        }
        
        int count = 0;
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int k=0;k<size;k++){
                NestedInteger node = q.poll();
                if(node.isInteger()){
                    sum+= (count*node.getInteger());
                }else{
                    for(NestedInteger val : node.getList()) q.offer(val);
                }
            }
        }
        
        return sum;
    }
}
