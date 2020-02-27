package leetcode.conquer.sol.string;

/*
 * exclude all the guarantee false cases first
 * then if they are the same length then just loop through the indexes same time, if two indexes are different return false; 
 * if length not the same we loop from the smaller one(in my code s). if char not the same we increment the long string's index(t, index j) until the identical
 * char is found, in the end if j - i > 1 then we know we have to do more than just insert/delete to make the two string identical.
 * 
 * in the end we check if count is greater than 1 or j-1>1
 * Time O(n) Space can be constant but I added the toCharArray for faster loop
 */
public class OneEditDistance {
	public OneEditDistance() {}
	
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() > t.length()) return isOneEditDistance(t,s);
        if(t.length() - s.length() > 1 || t.equals(s)) return false;
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int i = 0;
        int j = 0;
        int count = 0;
        if(arr1.length == arr2.length){
            for(i=0;i<arr1.length;i++)
                if(arr1[i] != arr2[j++]) count++;
        }else{
            for(i=0;i<arr1.length && j<arr2.length;i++)
                if(arr1[i] != arr2[j++]) i--;
        }
        
        
        return count>1 || j-i > 1? false : true;
    }
}
