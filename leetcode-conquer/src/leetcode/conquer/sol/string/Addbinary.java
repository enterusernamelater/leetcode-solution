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

        char[] chs1 = a.toCharArray();
        char[] chs2 = b.toCharArray();
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=chs1.length-1, j=chs2.length-1; i>=0 || j>=0 || c>0; i--,j--){
            int val1 = i<0? 0 : chs1[i]-'0';
            int val2 = j<0? 0 : chs2[j]-'0';
            
            int res = (val1 + val2 + c)%2;
            c = (val1 + val2 + c)/2;
            sb.append(res);
        }

        return sb.reverse().toString();
    }
}
