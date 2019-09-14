package leetcode.conquer.sol.string;

/*
 * first find the first starting index, see if is digit or +, - if not return 0
 * then check all char after the starting indexs after the the starting that are digits 
 * stops at the one that is not
 * each time we check we use long to compare Integer's max/min value
 * Time O(n) Space constant
 * this is a really stupid question..
 */
public class StringToIntegerAtoi {
	public StringToIntegerAtoi() {}

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
			if(Character.isDigit(str.charAt(i))){
				Long val = Long.valueOf(str.substring(index,i+1)) * sign;
				if(val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
				if(val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
				res = val.intValue();
			}else{
				break;
			}
		}

		return res;
	}
}
