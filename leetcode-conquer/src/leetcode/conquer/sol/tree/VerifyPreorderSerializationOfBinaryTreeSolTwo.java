package leetcode.conquer.sol.tree;

/*
 * a faster solution for VerifyPreorderSerializationOfBinaryTree by counting the diff on the nodes you traverse
 * + 2 when u see a node because a node has possibility of having two nodes and -1 for a traverse meaning you already traversed a node.
 * the diff should be 0 meaning you traversed all if not then result is false; 
 * referring to sol link:
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
 * time o(n) space o(1), depends on the split. 
 */
public class VerifyPreorderSerializationOfBinaryTreeSolTwo {
	public VerifyPreorderSerializationOfBinaryTreeSolTwo(){}

	public boolean isValidSerialization(String preorder) {
		if(preorder == null || preorder.length() == 0) return false;
		String [] arr = preorder.split(",");

		int diff = 1;

		for(String s : arr){
			if(--diff <0) return false;
			if(!"#".equals(s)) diff+=2;
		}

		return diff == 0;
	}
}
