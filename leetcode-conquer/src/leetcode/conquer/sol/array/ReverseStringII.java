package leetcode.conquer.sol.array;

/*
 * This is a swap on every 2*k block 
 * referring to leetcode sol on this question.
 * time o(N), space o(N)
 */
public class ReverseStringII {
	public ReverseStringII() {}
	
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i+=2*k){
            int end = Math.min(i+k-1,arr.length-1);
            int start = i;
            while(start<end){
                char tmp = arr[start];
                arr[start++]=arr[end];
                arr[end--]=tmp;
            }
        }
        
        return String.valueOf(arr);
    }
}
