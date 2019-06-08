package leetcode.conquer.sol.recursion;

import java.util.ArrayList;
import java.util.List;
/*
 * This sol is a reference to the youtube link below:
 * https://www.youtube.com/watch?v=bsBTFtdLnmI
 * time o(2^n) because we basically need to find all combination of word on each letter
 * space o(2^n) since will have all combination result.
 */
public class GeneralizedAbbreviation {
	public GeneralizedAbbreviation() {}
	
	 List<String> res = new ArrayList<>();
	    public List<String> generateAbbreviations(String word) {
	        helper(word,0,0,"");
	        return res;
	    }
	    
	    void helper(String s, int p, int count, String comb){
	        if(p == s.length()){
	            if(count>0)
	                comb+=String.valueOf(count);
	            res.add(comb);
	            return;
	        }
	        
	        //Abbreviation
	        helper(s,p+1,count+1,comb);
	        
	        if(count>0)
	            comb += String.valueOf(count);
	        comb+=s.charAt(p);
	         helper(s,p+1,0,comb);
	    }
}
