package leetcode.conquer.sol.tree;

import leetcode.conquer.tree.Node;
/*
 * this solution is copied from the discussion board in leetcode
 * based on the BST property, if x.right is null then only way to find the larger one
 * is keep finding its parent, once we found one that is greater that x.val we exist the while
 * or we return null
 * if the node has right val, then we traverse the right val's left side until the end, which is 
 * the val that is the smallest but still greater the x.val.
 */
public class InorderSuccessorInBSTII {
	public InorderSuccessorInBSTII() {}
	
    public Node inorderSuccessor(Node x) {
        if(x.right == null){
            Node res = x.parent;
            while(res!= null && res.val<x.val){
                res = res.parent;
            }
            return res;
        }else{
            Node res = x.right;
            while(res.left!=null)
                res = res.left;
            
            return res;
        }
    }
}
