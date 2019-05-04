package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.Node;

/*
 * this is a preorder solution that goes from right to the left to connext each node's next
 * the reason of going from right to next is for the following case:
 *                  1
 *                2   3
 *               4 5 6 7
 *              8       9  
 *if we traverse from left to right preorder, when we reach node 8 we realize that 4's right is null 
 *so we look for the root's next. since we are traversing from left to right preorder, only 4  -> 5 ->6 are 
 *connected. But the right link for 8 is actually 9 at very end of the right side but have not been traversed yet. therefore preorder traverse from 
 *left to right wil not work. However from right to left will, because we are always comparing the previous nodes to the nodes that are already traversed.
 *time o(n), space on paper is o(1) since we are not using anything addition memory allocation. 
 */
public class PopulatingNextRightPointersInEachNodeII {
	public PopulatingNextRightPointersInEachNodeII() {}
	
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    
    void helper(Node root){
        if(root == null) return;
        
        if(root.left != null){
            root.left.next = root.right != null? root.right : getNext(root.next);
        }
        
        if(root.right != null){
            root.right.next = getNext(root.next);
        }
    
         helper(root.right);
         helper(root.left);
    }
    
    Node getNext(Node nextRoot){
        if(nextRoot == null) return null;
        if(nextRoot.left != null) return nextRoot.left;
        if(nextRoot.right != null) return nextRoot.right;
        return getNext(nextRoot.next);
    }
}
