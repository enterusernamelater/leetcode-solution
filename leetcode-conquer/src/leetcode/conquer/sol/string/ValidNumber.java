package leetcode.conquer.sol.string;

/*
 * this is a state switch question that we need to handle . +/- e numbers and other characters 
 * separately to achieve the final validation. cases are below:
 * +/-: can only appear at the beginning of the string or beginning of the e. flip start to true if start with +/-
 * e: can only appear once, cannot appear in the beginning of the string and must have a valid number before e
 * .: can only appear once, cannot appear after e. flip start to true if starts with a .
 * numbers: valid always, flip start flag to true if is false and flip hasDigit flag to true if false.
 * any other creatures appear in the string return false immediately
 * in the end of the return we check if the string ended with a dot has no number or an e with no following
 * Time o(N)
 * Space constant
 * 
 */
public class ValidNumber {
	public ValidNumber() {}

	public boolean isNumber(String s) {
		if(s == null || s.length() == 0) return false;
		s=s.trim();
		if(s.length() == 0) return false;
		char[] signs = new char[]{'+','-'};
		char e = 'e';
		char dot = '.';
		boolean started =false;
		boolean hasE=false;
		boolean hasDot = false;
		boolean hasDigit = false;
		char[] arr = s.toCharArray();
		for(int i=0;i<arr.length;i++){
			if(arr[i] == signs[0] || arr[i] == signs[1]){
				if(started) return false;
				if(!started) started=true;
			}else if(arr[i] == dot){
				if(hasE || hasDot) return false;
				if(!hasDot) hasDot = true;
				if(!started) started=true;

			}else if(arr[i] == e){
				if(!started || hasE || !hasDigit) return false;
				if(!hasE)hasE = true;
				hasDigit = false;
				started = false;
			}else if(Character.isDigit(arr[i])){
				if(!started) started=true;
				if(!hasDigit) hasDigit=true;
			}else{
				return false;
			}
		}
		//we check if we ended with a dot but we have no digit or we ended with an e and have no digit after
		//this return is a negate of the following:
		//!hasDigit && (hasE || hasDot)
		return hasDigit || (!hasE && !hasDot);
	}
}
