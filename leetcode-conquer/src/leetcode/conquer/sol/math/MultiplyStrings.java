package leetcode.conquer.sol.math;

/*
 * Multiply Strings watch this to understand https://www.youtube.com/watch?v=Z_xGMYUSEJ8
 * Time O(num1.length*num2.length)
 * Space O(num1.length + num2.length);
 */
public class MultiplyStrings {
	public MultiplyStrings() {}

	public String multiply(String num1, String num2) {
		char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();
		int[] res = new int[arr1.length+arr2.length];

		for(int i=arr1.length-1;i>=0;i--){
			for(int j=arr2.length-1;j>=0;j--){
				int mult = (arr1[i]-'0')*(arr2[j]-'0') + res[i+j+1];
				res[i+j+1] =  mult%10;
				res[i+j] += mult/10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int val : res){
			if(sb.length() == 0 && val == 0) continue;
			sb.append(val);
		}

		return sb.length() == 0? "0":sb.toString();
	}
}
