package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * a pretty straight forward solution that we first split the string with "/"
 * then we pop when we encounter ".." we push when we encounter a actual string
 * in the end we build the result by pop the stack. the first pop is the tail and the last pop
 * is the front
 * Time O(n) Space O(n)
 */
public class SimplifyPath {
	
    private final static String SLASH = "/";
    private final static String DOT =".";
    private final static String DOUBLE_DOT = "..";
    
	public SimplifyPath() {}
    
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return path;
        String[] arr = path.split(SLASH);
        
        Deque<String> stack = new ArrayDeque<>();
        
        for(String s : arr){
            if(DOUBLE_DOT.equals(s)){
                if(!stack.isEmpty()) stack.pop();
            }else if(!DOT.equals(s) && s.length()>0){
                stack.push(s);
            }   
        }
        if(stack.isEmpty()) return SLASH;
        
        String res = "";
        while(!stack.isEmpty()){
            res = SLASH + stack.pop() + res;
        }
        
        return res;
    }
}
