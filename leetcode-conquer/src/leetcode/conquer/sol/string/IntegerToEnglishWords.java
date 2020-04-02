package leetcode.conquer.sol.string;

/*
 * using recursion to keep dividing the number the code if pretty self explanatory.. 
 * make sure to trim, its possible additional spaces will be added in the helper returns
 * 
 */
public class IntegerToEnglishWords {
	public IntegerToEnglishWords() {}

	String[] one = new String[] {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve",
			"Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	String[] ten = new String[] {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	public String numberToWords(int num) {
		if(num == 0) return "Zero";
		String res = helper(num);
		return res.trim();
	}

	private String helper(int num){
		if(num<20) return one[num%20];
		else if(num<100) return ten[num/10] + " " + helper(num%10).trim();
		else if(num<1000) return helper(num/100).trim() + " Hundred " + helper(num%100).trim();
		else if(num<1000000) return helper(num/1000).trim() + " Thousand " + helper(num%1000).trim();
		else if(num<1000000000) return helper(num/1000000).trim() + " Million " + helper(num%1000000).trim();
		else return helper(num/1000000000).trim() + " Billion " + helper(num%1000000000).trim();
	}
}
