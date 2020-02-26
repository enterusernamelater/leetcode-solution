package leetcode.conquer.sol.design;

/*
 * we need to grab 4 chars from the file by using read4 and store them into buff
 * two cases to handle: one when we are asking more n than actual chars in the file
 * two we are asking less words to store into buff from file
 * we need to stop storing to buff once the either conditions above are reached. 
 * Time O(n)
 * Space constant
 */
public class ReadNCharactersGivenRead4 {
	public ReadNCharactersGivenRead4() {}

	public int read(char[] buf, int n) {
		char[] arr = new char[4];
		int i = 0, val = read4(arr);
		//loop continues if and only if we have more chars in the file and still require more storing to buff arr
		//if required storing reached or all chars from file are read we quit the loop and return the next index of the last stored index
		//which is the total length;
		for(i = 0; i<n && val > 0;){
			//same conditions check here, only read arr(return from read4) up to the index which the file is read. if only two chars left in the file
			//the val here will be 2 because only two chars need to be read
			//and of course the i needs to be smaller than n.
			for(int j=0; j<val && i<n; j++) buf[i++] = arr[j];
			val = read4(arr);
		}

		return i;
	}

	//a mocked method to store the solution
	public int read4(char[] arr) {return 0;}
}
