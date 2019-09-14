package leetcode.conquer.sol.array;

/*
 * Just read the question..this solution is self explanatory
 * Time O(n) Space constant
 */
public class IntegerToRoman {
	public IntegerToRoman() {}
	
    public String intToRoman(int num) {
        String[] k = {"","M","MM","MMM"};
        String[] h = {"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] t = {"", "X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] d = {"", "I","II","III","IV","V","VI","VII","VIII","IX"};
        
        return k[num/1000] + h[(num%1000)/100] + t[(num%100)/10] + d[num%10];
    }
}
