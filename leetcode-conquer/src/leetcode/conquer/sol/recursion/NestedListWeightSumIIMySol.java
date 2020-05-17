package leetcode.conquer.sol.recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.conquer.sol.recursion.util.NestedInteger;

public class NestedListWeightSumIIMySol {
	public NestedListWeightSumIIMySol() {}
	
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        int size = helper(nestedList);
        
        Queue<NestedInteger> q = new LinkedList<>();
        for(NestedInteger val : nestedList) q.offer(val);
        int sum = 0;
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int k =0;k<qsize;k++){
                NestedInteger node = q.poll();
                
                if(node.getInteger() == null){
                    for(NestedInteger val : node.getList()){
                        q.offer(val);
                    }
                }else{
                    sum+=node.getInteger() * size;
                }
            }
            size--;
        }
        
        return sum;
    }
    
    private int dfs(List<NestedInteger> nestedList, int size){
        int sum =0;
        for(NestedInteger val : nestedList){
            if(val.getInteger() == null){
                sum+=dfs(val.getList(),size-1);
            }else{
                sum+=val.getInteger()*size;
            }
        }
        
        return sum;
    }
    
    private int helper(List<NestedInteger> nestedList){
        int res = 1;
        for(NestedInteger val : nestedList){
            if(val.getInteger() == null){
                int level = helper(val.getList()) + 1;
                res = Math.max(level,res);
            }
        }
        return res;
    }
}
