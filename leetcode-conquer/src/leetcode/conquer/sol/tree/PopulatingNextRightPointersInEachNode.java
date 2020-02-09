package leetcode.conquer.sol.tree;

import java.util.LinkedList;
import java.util.Queue;

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
	
	/*
	 * first preorder traverse and connect each left and right nodes' next
	 * then once return to the root, we connect each nodes right to the next's left 
	 * imaging as close gap between two sub PERFET BINARY TREEs
	 * Time O(n)
	 * space constant as recursion stack doesnt count
	 */
    public Node connectMySol(Node root) {
        helper(root);
        return root;
    }
    
    private void helperMySol(Node root){
        if(root == null) return;
        if(root.left != null && root.right != null){
            root.left.next = root.right;
        }
        
        helper(root.left);
        helper(root.right);
        
        Node next = root.next;
        Node right = root.right;
        while(right != null && next != null){
            right.next = next.left;
            right = right.right;
            next = next.left;
        }
    }
	
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
    
    
    public Node connectSolTwo(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                Node node = q.poll();
                node.next = i == size-1? null : q.peek();
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
        }
        
        return root;
    }
}
