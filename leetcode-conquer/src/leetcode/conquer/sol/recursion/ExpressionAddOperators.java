package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * this solution I really dont need to write anything..this link below has a perfect explanation, the first solution
 * https://www.youtube.com/watch?v=v05R1OIIg08
 * time o(4^n) because we separte the indexes between spaces and each space we can fill " ","+","-","*"
 * space o(4^n) worst case you will end up having 4^n combinations.
 */
public class ExpressionAddOperators {
	public ExpressionAddOperators() {}
	
	List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        helper(num,target,"", 0,0,0);
        return res;
    }
    
    private void helper(String num, int target, String exp, int index, int cur, int prev){
        if(cur==target && index == num.length()){
            res.add(exp);
            return;
        }
        
        for(int i=1; i<=num.length()-index; i++){
            String subStr = num.substring(index,index+i);
            if(subStr.length()>1 && subStr.charAt(0) == '0') break;
            
            Long longVal = Long.valueOf(subStr);
            if(longVal>Integer.MAX_VALUE) break;
            int intVal = longVal.intValue();
            if(index==0){
                helper(num,target,subStr,i,intVal,intVal);
                continue;
            }
            
            helper(num,target,exp+"+"+intVal,index+i,cur+intVal,intVal);
            helper(num,target,exp+"-"+intVal,index+i,cur-intVal,-intVal);
            helper(num,target,exp+"*"+intVal,index+i,cur-prev+prev*intVal,prev*intVal);   
        }
    }
}
