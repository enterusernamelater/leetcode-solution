package leetcode.conquer.sol.binarysearch;

import leetcode.conquer.sol.recursion.util.GuessGame;

/*
 * binary search finding the right number
 * o(log(n))
 */
public class GuessNumberHigherOrLower implements GuessGame{

	public GuessNumberHigherOrLower() {}
	
	public int guessNumber(int n) {

		int l = 1;
		int h = n;

		while(l<=n){
			int mid = l+(h-l)/2;
			int val = guess(mid);
			if(val == 0) return mid;
			if(val == -1){
				h=mid-1;
			}else{
				l=mid+1;
			}
		}
		return 0;
	}

	@Override
	public int guess(int num) {
		return 0;
	}
}
