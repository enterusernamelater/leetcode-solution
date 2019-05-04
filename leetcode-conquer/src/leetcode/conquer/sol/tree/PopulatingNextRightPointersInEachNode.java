package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.Node;

/*
 * this questions is just a preorder recursive traverse,
 * always keep in mind this it is a perfect binary tree. We first check if node.left is not null if it is then we link node.left to the node.right
 * this logic is pretty simple, the hard part is trying to link the right most node on left subtree to the left most node on the right subtree
 * to do this. we need to check if the root.next is not null. if is true then we link the root.right to the root.next.left (which jumps to the root of the next subtree)
 * time is o(n) space is actually o(1) since we use the buildin next val instead of decalre new variables. 
 */
public class PopulatingNextRightPointersInEachNode {
	public PopulatingNextRightPointersInEachNode() {}
	
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    
    void helper(Node root){
        if(root == null) return;
        
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        
        helper(root.left);
        helper(root.right);
    }
}
