package leetcode.conquer.sol.binarysearch;

/*
 * a binary search sol referring to leetcode solutions
 * Time O(log(n)) Space O(1)
 */
public class FirstBadVersion {
	public FirstBadVersion() {}
	
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        
        while(l<r){
            int mid = l+(r-l)/2;
            if(isBadVersion(mid)){
                r = mid;
            }else{
                //beacause we know mid is not bad version.
                l = mid + 1;
            }
        }
        return l;
    }
    
    private boolean isBadVersion(int mid) {
    	return Math.random() >= 0.5;
    }
}

