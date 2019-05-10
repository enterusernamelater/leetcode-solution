package leetcode.conquer.sol.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * this is a stack sol, and the link of explanation is below:
 * https://www.programcreek.com/2015/01/leetcode-verify-preorder-serialization-of-a-binary-tree-java/
 * time o(n), sapce o(n)
 */
public class VerifyPreorderSerializationOfBinaryTree {
	public VerifyPreorderSerializationOfBinaryTree() {}
	
    public boolean isValidSerialization(String tree) {
        if(tree == null || tree.length() == 0) return false;
        
        String[] arr = tree.split(",");
        Deque<String> stack = new ArrayDeque<>();
        for(String s : arr){
            while(!stack.isEmpty() && "#".equals(s) && stack.peek().equals(s)){
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(s);
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
