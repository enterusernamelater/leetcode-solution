package leetcode.conquer.sol.tree.bst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        StringBuilder sb = new StringBuilder("");
        helper(root,sb);
        return sb.toString();
    }

    void helper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null~");
        }else{
            sb.append(root.val);
            sb.append("~");
            helper(root.left,sb);
            helper(root.right, sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("~");
        return deserializeHelper(new LinkedList<>(Arrays.asList(arr)));
    }
    
    TreeNode deserializeHelper(List<String> arr){
        if(arr.get(0).equals("null")) {
            arr.remove(0);
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(arr.get(0)));
        arr.remove(0);
        node.left=deserializeHelper(arr);
        node.right=deserializeHelper(arr);
        
        return node;
    }

}
