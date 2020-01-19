package leetcode.conquer.sol.string;

/*
 * simply logic. build the wanted string one at a time until n is reached
 * starting from the initial string "1" to provide n.
 * Time O(n)
 * Space O(n)
 * 
 */
public class CountAndSay {
	public CountAndSay() {}
	
    public String countAndSay(int n) {
        if(n == 0) return "";
        String val = "1";
        while(n>1){
            char[] arr = val.toCharArray();
            int repeat=1;//starting from 1 because counting the first char
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<arr.length;i++){
                if(i+1 < arr.length && arr[i] == arr[i+1]){
                    repeat++;
                }else{
                    sb.append(repeat);
                    sb.append(String.valueOf(arr[i]));
                    repeat = 1;//resetting to 1 as counting the next char
                }
            }
            n--;
            val = sb.toString();
        }
        
        return val;
    }
}
