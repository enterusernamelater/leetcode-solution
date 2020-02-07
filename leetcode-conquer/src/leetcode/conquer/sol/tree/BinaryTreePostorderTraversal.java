package leetcode.conquer.sol.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.conquer.tree.TreeNode;

/*
 * post order traversal: left, right root.
 * we first traverse all the way down from the left
 * we reached the end we pop the node up from the stack and added to the result if the node has no right branch.
 * when a node with right branch is found, meaning now the node is a root. we push the root's right branch node
 * to the stack then we null the root's right branch so when we turn to this root from the stack 
 * we can pop the root out as the root is already visited
 * 
 * the root.right becomes the new root, and the stating point initialized to the root.right.left
 * then the logic above repeats, eventually the traverse will return to the node that we null out its right branch
 * by that time we just simply pop the root out of the stack and add it's val to the res list in the while loop
 * 
 * recursion solution attached too if anyone is interested 
 *
 * Time O(n)
 * Space O(n)
 */
public class BinaryTreePostorderTraversal {
	public BinaryTreePostorderTraversal() {}
	
	private List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        //initialize stack
        stack.push(root);
        root = root.left;
        while(!stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            while(!stack.isEmpty() && stack.peek().right == null) res.add(stack.pop().val);
            
            if(!stack.isEmpty()){
            	//the tricker here is we null out the root's right once a root is reached
            	//so we the stack returns the root's value will be added to the result.
                root = stack.peek();
                TreeNode right = root.right;
                //making the root.right = null as the root has already been visited.
                root.right = null;
                stack.push(right);
                root = right.left;
            }
        }
        
        return res;
    }
    
    private void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}
