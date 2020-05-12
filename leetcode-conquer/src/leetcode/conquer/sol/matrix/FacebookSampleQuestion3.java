package leetcode.conquer.sol.matrix;

public class FacebookSampleQuestion3 {
	public FacebookSampleQuestion3() {}

	public boolean isOneEditDistance(String a, String b) {
		if((a == null || a.length() == 0) && (b == null || b.length() == 0)) return false;
		if(a.length() > b.length()) return isOneEditDistance(b,a);
		if(Math.abs(a.length() - b.length()) > 1) return false;
		if(a.length() == 0 || b.length() == 0) return true;
		if(a.equals(b)) return false;

		char[] arra = a.toCharArray();
		char[] arrb = b.toCharArray();
		int count = 0;
		if(a.length() == b.length()) {
			for(int i=0;i<a.length();i++) {
				if(arra[i] != arrb[i]){
					count++;
				}
				if(count > 1) return false;
			}
		}else {
			int j=0;
			for(int i=0;i<a.length();i++) {				
				if(arra[i] != arrb[j]) {
					count++;
					i--;
				}
				j++;

				if(count > 1) return false;
			}
		}

		return true;
	}
}
