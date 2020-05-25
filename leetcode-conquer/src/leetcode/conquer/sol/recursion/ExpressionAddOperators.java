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
	
	private List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) return new ArrayList<>();
        dfs(num,"",target,0,0,0);
        return res;
    }
    
    private void dfs(String num, String str, int target, int index, int curr, int prev){
        if(target == curr && index == num.length()){
            res.add(str); return;
        }
        
        //in this case index is always the starting point of the substring
        for(int i=index+1;i<=num.length();i++){
            String value = num.substring(index,i);
            if(value.length()>1 && value.charAt(0) == '0') return;
            Long longval = Long.valueOf(value);
            if(longval > Integer.MAX_VALUE) return;
            int intval= longval.intValue();
            
            if(index == 0){
                dfs(num,value,target,i,intval,intval);
                continue;
            }
            
            dfs(num,str+"+"+value,target,i,curr+intval,intval);
            dfs(num,str+"-"+value,target,i,curr-intval,-intval);
            /*
             * during multiplication we times the previous but also minus the previous from the total because the previous
             * is now used in the multiplication the previous calculation no longer valid.
             */
            dfs(num,str+"*"+value,target,i,curr - prev + intval*prev, prev*intval); 
        }
    }
}
