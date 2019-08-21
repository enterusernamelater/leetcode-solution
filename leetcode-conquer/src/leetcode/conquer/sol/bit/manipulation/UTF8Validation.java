package leetcode.conquer.sol.bit.manipulation;

/*
 * this is a bit manipulation soluton see comments for explanation
 * but the logic is the same for my solution
 * Time O(n) Space constant
 */
public class UTF8Validation {
	public UTF8Validation() {}

	public boolean validUtf8(int[] data) {
		if(data == null || data.length == 0) return false;
		int bytes = 0;
		for(int i=0;i<data.length;i++){
			if(data[i] > 255) return false; // 1 after 8th digit, 100000000
			if((data[i] & 128) == 0){ // 0xxxxxxx, 1 byte, 128(10000000)
				bytes = 1;
			}else if((data[i] & 224) == 192){ // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
				bytes = 2;
			}else if((data[i] & 240) == 224){ // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
				bytes = 3;
			}else if((data[i] & 248) == 240){ // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
				bytes = 4;
			}else{
				return false;
			}
			if(i+bytes-1 > data.length -1) return false;

			for(int j=i+1;j<i+bytes;j++){ // check that the next n bytes start with 10xxxxxx
				if((data[j] & 192) != 128) return false; // 192(11000000), 128(10000000)
			}

			i=i+bytes-1;
		}

		return true;
	}
}
