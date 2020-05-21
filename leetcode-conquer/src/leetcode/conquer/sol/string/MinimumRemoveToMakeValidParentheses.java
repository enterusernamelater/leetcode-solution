package leetcode.conquer.sol.string;

/*
 * going from lefr -> right and right -> left the same time
 * replace all invalid with $
 * remove $ at the end
 * Time O(n)
 * Space constant
 */
public class MinimumRemoveToMakeValidParentheses {
	public MinimumRemoveToMakeValidParentheses() {}
	
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) return s;
        int openl =0;
        int openr = 0;
        char[] chs = s.toCharArray();
        for(int i=0,j=chs.length-1;i<chs.length && j>=0;i++,j--){
            if(chs[i] == '(')openl++;
            else if(chs[i] == ')') openl--;
            
            if(chs[j] == ')')openr++;
            else if(chs[j] == '(') openr--;
            
            if(openl<0){
                chs[i] = '$';
                openl++;
            }
            
            if(openr<0){
                chs[j] = '$';
                openr++;
            }
        }

        String res = new String(chs);
        return res.replace("$","");
    }
}
