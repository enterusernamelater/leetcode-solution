package leetcode.conquer.sol.stack;
import java.util.*;

/*
 * basically using stack tracking start function id, while using res arr store the number of units spent in the stack's id
 * pop when encounter an end from stack while adding the units to the result function index.
 * Time O(n)
 * Space O(n)
 */
public class ExclusiveTimeOfFunctions {
	public ExclusiveTimeOfFunctions() {}
	
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) return new int[0];
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int pre = 0;
        for(int i=0;i<logs.size();i++){
            String[] log1 = logs.get(i).split(":");
            Integer time1 = Integer.valueOf(log1[2]);
            Integer index1 = Integer.valueOf(log1[0]);
 
            if(log1[1].equals("start")){
                if(!stack.isEmpty()) res[stack.peek()] += time1-pre;
                stack.push(index1);
                pre=time1;
            }else{
                res[stack.pop()] += time1-pre+1;
                pre=time1+1;
            }
        }
        return res;
    }
}
