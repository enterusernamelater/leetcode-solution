package leetcode.conquer.sol.string;

/*
 * just like add a int in String we keep a carry
 * adding to the end.
 * start with the smaller length of the string, after that we are only adding the larger
 * string with the carry
 * Time o(N)
 * space constant
 */
public class Addbinary {
	public Addbinary() {}
	
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) return addBinary(b,a);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int j = a.length()-1;
        for(int i=b.length()-1;i>=0;i--){
            int val1 = a.charAt(j) - '0';
            int val2 = b.charAt(i) - '0';
            int total = val1 + val2 + carry;
            sb.append(total%2);
            carry = total/2;
            j--;
        }
        //add the rest;
        for(int i=j; i>=0; i--){
            int val = a.charAt(i) - '0';
            int total = val + carry;
            sb.append(total%2);
            carry = total/2;
        }
        if(carry > 0){
           sb.append(carry);
        }
        
        //string builder reverse is neat
        return sb.reverse().toString();
    }
}
