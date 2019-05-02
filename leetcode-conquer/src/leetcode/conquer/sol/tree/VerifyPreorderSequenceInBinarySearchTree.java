package leetcode.conquer.sol.tree;

import java.util.ArrayDeque;
import java.util.Deque;
/*
 * this solution is referring to: 
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space
 * the logic is find the pattern of the array, when the element from the array goes from small to big, that means the 
 * preorder traverse has switched branch from left to right, when this happens we use the stack that tracks the traversed value
 * and pop until we find the root, since in BST the root is smaller than the right. and the root cannot be greater than any of the traverse from the right branch
 * this check repeats until the end. if all satisfies we return true;
 */
public class VerifyPreorderSequenceInBinarySearchTree {
	public VerifyPreorderSequenceInBinarySearchTree() {}
	
	
	//time o(n) space o(n)
    public boolean verifyPreorderStackSol(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int low = Integer.MIN_VALUE;
        for(int i : preorder){
            if(i<low) return false;
            //switch branch from left to right
            while(!stack.isEmpty() && i>stack.peek())
                low = stack.pop();
            
            stack.push(i);
        }
        
        return true;
    }
    
    
    //time o(n) space o(1) since the input array is now used as stack
    public boolean verifyPreorderConstantSpace(int[] preorder) {
        int leftSmallest = Integer.MIN_VALUE; int i = -1;
        for(int p : preorder){
            if(leftSmallest > p) return false;
            
            while(i>=0 && p > preorder[i])
                leftSmallest = preorder[i--];
            
            preorder[++i]=p;
        }
        
        return true;
    }
}
