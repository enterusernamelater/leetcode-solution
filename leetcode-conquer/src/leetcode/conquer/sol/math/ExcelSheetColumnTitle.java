package leetcode.conquer.sol.math;

/*
 * this question is similar to dividing a string integer
 * but we need to handle a special case that we cant allow n/=26 to expand
 * when we have landed a 'z' character
 * 26 rotates can happen on a single index before expansion, but when n=26, 26/26=1 which treats letter 'z' the last rotate of the 26
 * as an expansion
 * this is an extra expansion we dont need so we take out from our leftover expansion to compute 'n/=26' 
 * when our mode is 0;
 * Time O(N)
 * Space constant
 */
public class ExcelSheetColumnTitle {
	public ExcelSheetColumnTitle() {}
	
	public String convertToTitle(int n) {
		String[] arr = new String[]{"Z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
		String res = "";
		while(n>0){
			int mod = n%26;
			res = arr[mod] + res;
			n/=26;
			if(mod == 0) n--; 
			//handle a special case when n%26 = 0 = 'z', 
			//we dont expand on 'z' as 'z' is the last char before expandsion. 
			//but 26/26 =1 meaning next loop will expand our res to have a leading A this is wrong.
		}
		return res;
	}
}
