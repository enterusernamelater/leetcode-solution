package leetcode.conquer.sol.string;

/*
 * 4 pointer appraoch, two pointer for the first string, another two pointer for the second string
 * find each substring and compare return false on the following conditions
 * str1 and str2 is not the same and str1 length is less than 3
 * str2.length is greater than str1
 * if str1 and str2 are different
 * otherwise we increment the two pointer
 * Time O(n)
 * space constant
 */
public class ExpressiveWords {
	public ExpressiveWords() {}
	
    public int expressiveWords(String s, String[] words) {
        if(words == null || words.length == 0 || s == null || s.length() == 0) return 0;
        int res = 0;
        
        for(String word : words){
            if(isValid(s,word)) res++;
        }
        return res;
    }
    
    private boolean isValid(String word1, String word2){
        int i=0,i1=1;
        int j=0,j1=1;
        while(i1<=word1.length() && j1<=word2.length()){
            while(i1<word1.length() && word1.charAt(i1) == word1.charAt(i1-1)) i1++;
            String str1 = word1.substring(i,i1);
            while(j1<word2.length() && word2.charAt(j1) == word2.charAt(j1-1)) j1++;
            String str2 = word2.substring(j,j1);
            if(str1.equals(str2)){
                i=i1++;
                j=j1++;
                continue;
            }
            if(str2.length() > str1.length() || str1.length() < 3) return false;
            if(str1.charAt(0) != str2.charAt(0)) return false;
            i=i1++;
            j=j1++;
        }
        
        return i1 > word1.length() && j1 > word2.length();
    }
}
