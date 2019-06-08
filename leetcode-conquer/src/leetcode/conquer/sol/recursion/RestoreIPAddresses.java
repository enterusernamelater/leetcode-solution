package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * this is a backtracking solution, the tracking range is set to be length of 4 max.
 * time o(n*3^4) because each "." section has 3 digits to chose from and the max will be 81 combinations(each combination cause a loop) 
 * we can also see the time is constant o(1) simpily beacuase the total ip address to this problem is 2^32. so our search will eventually comes
 * to a constant peak.
 * space is a constant o(1) since ip address total is 2^32
 * 
 */
public class RestoreIPAddresses {
	public RestoreIPAddresses() {}
	
	List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() == 0) return res;
        helper(s,"",0,0);
        return res;
    }
    
    private void helper(String s, String comb, int index, int count){
        if(count >4) return;
        if(count==4 && index == s.length()){
            res.add(comb);
            return;
        }
        
        for(int i=1; 1<4 && index+i<=s.length();i++){
            String subStr=s.substring(index,index+i);
            if((subStr.length()>1 && subStr.charAt(0) == '0') || Integer.valueOf(subStr) >255) break;
            helper(s,comb+subStr+(count==3? "":"."),index+i,count+1);
        }
    }
}
