package leetcode.conquer.sol.string;

/*
 * its like making sure the give array is lexicographically sorted by the order. 
 * Time O(n)
 * space constant
 */
public class VerifyingAnAlienDictionary {
	public VerifyingAnAlienDictionary() {}
	
    public boolean isAlienSorted(String[] words, String order) {
        for(int k=1;k<words.length;k++){
            String str2 = words[k];
            String str1 = words[k-1];
            for(int i=0,j=0;i<str1.length() || j<str2.length();i++,j++){
            	//special case if the previous string finishes first then is valid other wise return false;
                int index1 = i>=str1.length()? Integer.MIN_VALUE : order.indexOf(str1.charAt(i));
                int index2 = j>=str2.length()? Integer.MIN_VALUE : order.indexOf(str2.charAt(j));
                if(index1==index2) continue;
                else if(index1>index2) return false;
                else break;
            }

        }
        return true;
    }
}
