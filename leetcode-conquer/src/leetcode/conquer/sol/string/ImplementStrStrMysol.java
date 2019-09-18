package leetcode.conquer.sol.string;

/*
 * my solution every index check for a match using while
 * Time O(n^2) space constant
 */
public class ImplementStrStrMysol {
	public ImplementStrStrMysol() {}

	public int strStr(String haystack, String needle) {
		if(needle == null || needle.length() == 0) return 0;

		char[] arr1 = haystack.toCharArray();
		char[] arr2 = needle.toCharArray();

		int j=0;
		int res = -1;
		for(int i=0;i<arr1.length;i++){
			res=i;
			int s = i;
			while(j<arr2.length && s < arr1.length && arr1[s] == arr2[j]){
				s++;
				j++;
			}
			//true or reset
			if(j == arr2.length){
				return res;
			}else{
				j=0;
				res = -1;
			}
		}

		return res;
	}
}
