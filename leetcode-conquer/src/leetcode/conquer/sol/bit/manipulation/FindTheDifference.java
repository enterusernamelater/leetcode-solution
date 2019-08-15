package leetcode.conquer.sol.bit.manipulation;

/*
 * this solution is based on the xor 
 * following 2 principles below:
 * 1. A value XORs itself equals 0. A value XORs 0 remains unchanged.
 * 2. XOR is commutative. meaning rearrange order will produce the same result.
 * so if to identical string xor each other, no mater what the order of the chars in the string is
 * xor will always produce zero.
 * therefore if we only have one different char in the array. 
 * when we xor the bot string the xor return will be the leftover char.
 * 
 * Time O(n) Space O(1)
 */
public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		char c = 0;
		for(int i = 0; i<s.length(); i++){
			c^=s.charAt(i);
		}

		for(int j = 0; j<t.length(); j++){
			c^=t.charAt(j);
		}

		return c;
	}
}

