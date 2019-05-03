package leetcode.conquer.sol.tree;

import java.util.HashMap;
import java.util.Map;

import leetcode.conquer.tree.TreeNode;
/*
 * This is a solution referring to link:
 * https://www.youtube.com/watch?v=53aOi0Drp9I
 * the first index of the preorder arr is always the root.
 * we use a hashmap to store the postorder element and index. we use divide and conquer method by dividing preleft, preright
 * postleft and postend(start,end). first we use the first element of preorder arr to determine the root, then get postorder arr's
 * index on the next root element prearr[preleft+1], because the last index of post order is also root. once the index is found we can determine the length
 * of the subtree by use the index - postleft.  the length of the subtree is now the key to divide both the preorder arr and postorder arr.
 * on the left: the preleft is increment by 1 and the preright, which is the end, is the start(preleft) + the length we found using the preorder +1 index 
 * on the post order arr. The postleft is the start of the post arr, the post right is postleft + the length of the subtree we found.
 * on the right: the preleft jumps after its left end, which is preleft+index+2, the preright is simpily the end of the preorder arr
 * postleft jumps to the postleft+index+1 and the end is postright -1. as mentioned the first index of preorder arr is the root the last index of post order
 * is also the root. so when we increment preleft by 1 at the same time we decrememnt the postright by 1.
 * since using the hashMap to look up the divide index, 
 * 
 * note: when we reach the last node in the tree, we need to check preleft+1 > preright if true we simpliy return the root, otherwise we get arrayoutofbound
 * exception
 * 
 * the time is o(n) and the space is o(n)
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	public ConstructBinaryTreeFromPreorderAndPostorderTraversal() {}
	
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<post.length;i++) map.put(post[i],i);
        
        return helper(pre,post,0,pre.length-1,0,post.length-1,map);
    }
    
    TreeNode helper(int[] pre, int[] post,int preleft, int preright, int postleft, int postright, Map<Integer,Integer> map){
        if(preleft>preright || postleft>postright) return null;
        
        TreeNode root = new TreeNode(pre[preleft]);
        
        if(preleft+1 > preright) return root;
        
        int index = map.get(pre[preleft+1]) - postleft;
        root.left = helper(pre, post, preleft+1,preleft+index+1,postleft,postleft+index,map);
        root.right = helper(pre,post, preleft+index+2, preright, postleft+index+1,postright-1,map);
        return root;
    }
	
}
