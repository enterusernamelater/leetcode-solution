package leetcode.conquer.sol.math;

/*
 * calculate number of 26 rotations on each index. for example yyz: the first index y meaning we have
 * 25*26*26 rotations, yz meaning we have 25*26 rotations, z means we have 26 rotations
 * add them all up we have our result
 * Time O(n)
 * Space constant
 */
public class ExcelSheetColumnNumber {
	public ExcelSheetColumnNumber() {}
	
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            res+= ((arr[i]-'A'+1)*Math.pow(26,arr.length-1-i));
        }
        
        return res;
    }
}
