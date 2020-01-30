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
    
	public SimplifyPath() {}
    
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return path;
        String[] strArr = path.split("/");
        String dot = ".";
        String doubleDot = "..";
        String slash = "/";
        Deque<String> stack = new ArrayDeque<>();
        
        for(String s : strArr){
            if(s.equals(doubleDot)){
                if(!stack.isEmpty()) stack.pop();
            }else if(s.length()>0 && !dot.equals(s)){
                stack.push(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,slash);
        }
        
        return sb.length() == 0? slash : sb.toString();
    }
}
