package leetcode.conquer.sol.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.conquer.tree.TreeNode;
/*
 * this is pretty much the same solution comparing to the leetCode solution
 * time complexity will be o(n) space should be o(n) as well for each call
 * pre order encode and pre-order decode
 * referring to solution : 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
 */
public class SerializeAndDeserializeBinaryTree {
	
	public SerializeAndDeserializeBinaryTree() {}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helpers(root,sb);
        return sb.toString();
    }
    
    private void helpers(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        
        sb.append(String.valueOf(root.val)+",");
        helpers(root.left,sb);
        helpers(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(arr));
        return helperd(queue);
    }
    
    private TreeNode helperd(Queue<String> q){
        if(q.peek().equals("null")){
            q.poll();
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(q.poll()));
        root.left = helperd(q);
        root.right = helperd(q);
        return root;
    }

}
