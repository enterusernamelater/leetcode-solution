package leetcode.conquer.sol.string;

/*
 * similar as the previous solution, the only difference is this time we only do substring once a non digit char is found
 * Time O(n) Space is constant
 */
public class StringToIntegerAtoiSolTwo {
	public StringToIntegerAtoiSolTwo() {}

	public int myAtoi(String str) {
		if(str == null || str.length() == 0) return 0;

		int i = 0;
		while(i < str.length() && str.charAt(i) == ' ') i++;
		if(i>str.length() - 1) return 0;

		if('+' != str.charAt(i) && '-' != str.charAt(i) && !Character.isDigit(str.charAt(i))) return 0;

		int index = i;
		int sign = 1;
		if('+' == str.charAt(i) || '-' == str.charAt(i)){
			if('-' == str.charAt(i)) sign = -1;
			index = i+1;
		}

		int res = 0;
		for(i=index; i<str.length(); i++){
			if(!Character.isDigit(str.charAt(i))){
				res = helper(str, index, i, sign);
				break;
			}
			if(i == str.length() -1){
				res = helper(str,index, str.length(), sign);
			}
		}

		return res;
	}

	private int helper(String str, int start, int end, int sign){
		String strVal = str.substring(start,end);
		//if the first char is not digit eg +-123 we return 0
		if(strVal.length() == 0) return 0;
		int j = 0;
		//remove the starting 0s.
		while(j<strVal.length() && strVal.charAt(j) == '0') j++;
		if(strVal.length()-j>10){
			if(sign == -1) return Integer.MIN_VALUE;
			return Integer.MAX_VALUE;
		}
		Long val = Long.valueOf(strVal) * sign;
		if(val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return val.intValue();
	}
}
