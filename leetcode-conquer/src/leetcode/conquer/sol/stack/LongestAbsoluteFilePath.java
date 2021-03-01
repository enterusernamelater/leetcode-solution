package leetcode.conquer.sol.stack;

import java.util.ArrayDeque;
import java.util.Deque;
/*
 * The idea of this solution is we push the trimed length of the string into stack
 * when a delta occurs between the current string level(str.lastIndexOf("\t") + 1) and stack level(stack size)
 * we pop the stack to reach the current string level's parent.
 * keep in mind that the popped parent level will not have duped direct/files because when dupliacte reached in the same level
 * the previous is poped right away.
 * we only need to pop stack to reach the cur string level becasue current string level increments from 0 to n see comment;
 * 
 *  Time O(n) Space O(n)
 */
public class LongestAbsoluteFilePath {
	public LongestAbsoluteFilePath() {}
	
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        
        String[] arr = input.split("\n");
        int res = 0;
        int cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(String str : arr){
            int level = str.lastIndexOf("\t") + 1;
            
            //this is the most important of the ticket
            //when stack is far down the level and current str is at top
            //we pop stack until stack reach one level above the current str level
            //the reason why stack.size > level is beacuse stack level increments from 1 to n
            //while the current level increments from 0 ... n
            while(stack.size() > level) cur -= stack.pop();
            
            int size = str.length() - level + 1; // string length minus spaces "\t" + "\"
            
            if(str.contains(".")){
                res = Math.max(cur+size-1,res);
                continue;
            }
            
            cur+=size;
            stack.push(size);
        }
        return res;
    }
}
