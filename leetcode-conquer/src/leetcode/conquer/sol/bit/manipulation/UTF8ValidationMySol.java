package leetcode.conquer.sol.bit.manipulation;

/*
 * My sol, we first convert each int to 8 bit String.
 * then for each string check starting see if it fit utf-8
 * start from "0", "110", "1110" or "11110" if not then is not a valid utf-8
 * once the start string is determined we check the following strings fits the property
 * Time O(n) Space O(n)
 */
public class UTF8ValidationMySol {
	public UTF8ValidationMySol() {}
	
    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0) return false;
        int n = data.length;
        String[] arr = new String[n];

        for(int i=0;i<n;i++){
            arr[i] = intToBinary(data[i]);
        }
        
        for(int i=0;i<n;i++){
            if(arr[i].startsWith("0")){
                continue;
            }else if(arr[i].startsWith("110")){
                if(i+1 > n-1 || !arr[i+1].startsWith("10")) return false;
                    i++;
            }else if(arr[i].startsWith("1110")){
                if(i+2 > n-1 || !arr[i+1].startsWith("10") || !arr[i+2].startsWith("10")) return false;
                i+=2;
            }else if(arr[i].startsWith("11110")){
                if(i+3 > n-1 || !arr[i+1].startsWith("10") || !arr[i+2].startsWith("10") || !arr[i+3].startsWith("10")) return false;
                i+=3;
            }else{
                return false;
            }
        }
        return true;
    }
    
    private String intToBinary(int i){
        String res = "";
        
        while(res.length() < 8){
            String val = i%2 == 0? "0" : "1";
            res = val + res;
            i >>= 1;
        }
        
        return res;
    }
}
