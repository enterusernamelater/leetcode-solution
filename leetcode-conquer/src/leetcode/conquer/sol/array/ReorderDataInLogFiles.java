package leetcode.conquer.sol.array;

import java.util.Arrays;

/*
 * this is basically a comareTo question
 * compareTo return -1 if val1 is first and val2 is second
 * compareTo return 1 if val1 is second val2 is first
 * compareTo return 0 is val1 and val2 the same
 * when calling string.comareTo. the string is compared by its lexicographical order
 * Time (nlog(n))
 * Space constant
 */
public class ReorderDataInLogFiles {
	public ReorderDataInLogFiles() {}
	
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length ==0) return logs;
        
        Arrays.sort(logs,(a,b) -> {
            String[] str1 = a.split(" ",2);
            String[] str2 = b.split(" ",2);
            
            boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
            
            if(!isDigit1 && !isDigit2){
                String val1 = str1[1];
                String val2 = str2[1];
                int compare = val1.compareTo(val2);
                if(compare != 0) return compare; // meaning if -1, 1 we return
                return str1[0].compareTo(str2[0]); //because the string is the same we compare the prefix.
            }
            
            return isDigit1? (isDigit2? 0 : 1) : -1;
        });
        return logs;
    }
}
