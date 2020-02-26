package leetcode.conquer.sol.string;

/*
 * trim the string
 * split with " "
 * and swap each string and skip space
 * append string back together and skip empty strings in the array
 * Time O(n)
 * Spce O(n)
 */
public class ReverseWordsInAString {
	public ReverseWordsInAString() {}
	
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        s = s.trim();
        if(s.length() == 0) return s;
        String[] arr = s.split(" ");
        
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            while(l<r && arr[l].equals(""))l++;
            while(l<r && arr[r].equals(""))r--;
            String tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            r--;
            l++;
        }
        
        StringBuilder sb = new StringBuilder(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i].length() == 0)continue;
            sb.append(" ");
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
