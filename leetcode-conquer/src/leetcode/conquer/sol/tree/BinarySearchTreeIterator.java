
package leetcode.conquer.sol.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.conquer.tree.TreeNode;

/*
 * the solution I had before is wrong because this question cannot allow memory capacity to be more than O(h).
 * the soltuion has a O(n) right at the start....tf man
 * to achieve a O(h) and a averaging O(1) complexity on the next() I used a stack
 * first push all left leafs to the stack. then we next() is called if the node we popped has no right
 * we do nothing and return the node's val. but if the node has a right. we need to pop the right into the stack
 * along with all its left leafs just like a inorder traverse and return the node's value
 * this logic continues until stack is empty
 * 
 * time complexity for next() averages to O(1) as there are times we will need to push some nodes into the stack at max O(h)
 * but its a one time thing
 * the memeory complexity for the stack at max is gonna be O(h)
 */
public class BinarySearchTreeIterator {
	private Deque<TreeNode> stack = new ArrayDeque<>(); //my solution
	private Queue<Integer> queue = new LinkedList<>(); 
	
	
	public BinarySearchTreeIterator() {}

	public BinarySearchTreeIterator(TreeNode root) {
		helper(root);
		while(root != null){
			stack.push(root);
			root = root.left;
		}
	}
	
	/** @return the next smallest number */
    public int nextMySol() {
        TreeNode curr = stack.pop();
        TreeNode node = curr.right;
        while(node!= null){
            stack.push(node);
            node = node.left;
        }
        return curr.val;
    }

	/** @return whether we have a next smallest number */
	public boolean hasNextMySol() {
		return !stack.isEmpty();
	}
	
	/*
	 * This solution uses the queue approach along with the inorder traverse.
	 * store everything vals to the queue by using the inorder traverse which results a 
	 * integer ascending order, because of the property of the BST.
	 * once stored then when iterate the numbers in the queue to find the smallest by pop the first one
	 * NOTE: stack-> last in first out, QUEUE -> first in first out.
	 * Time complexity O(N) for store the values in the queue O(1) for access. 
	 * Space complexity will be O(N)
	 */
	void helper(TreeNode root){
		if(root == null) return;

		helper(root.left);
		queue.add(root.val);
		helper(root.right);
	}

	/** @return the next smallest number */
	public int next() {
		return queue.poll();
	}


	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !queue.isEmpty();
	}
}
