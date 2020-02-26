package leetcode.conquer.sol.design;

/*
 * this is basically the same solution to ReadNCharactersGivenRead4
 * only difference is that now we are calling it multiple times so we need to store the file read positions
 * until the file has been read completely
 * we dont have to store buff's pos as each call buff gets a reset
 * Time is O(N)
 * space constant
 */
public class ReadNCharactersGivenRead4IICallMultipleTimes extends ReadNCharactersGivenRead4{
	public ReadNCharactersGivenRead4IICallMultipleTimes() {}

	private char[] arr = new char[4];
	private int arri = 0;
	private int val = read4(arr);

	public int read(char[] buf, int n) {
		int i= 0;
		while(i<n && val >0){
			//starts off reading from arri which is what we have left off from last call
			for(int j=arri; j<val&&i<n;j++){
				buf[i++] = arr[j];
				arri = j+1;
			}
			//only update the arr when we have finished reading the content in the arr
			if(arri == val){
				val = read4(arr);
				arri = 0;
			}
		}
		return i;
	}
}
