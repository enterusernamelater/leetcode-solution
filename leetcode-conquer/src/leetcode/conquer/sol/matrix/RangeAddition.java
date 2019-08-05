package leetcode.conquer.sol.matrix;

/*
 * Naive approache nothing to add here..
 * Time O(m*k) where k is the worst e - s;
 * Space O(length)
 */
public class RangeAddition {
	
	public RangeAddition() {}
	
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        if(updates == null || updates.length == 0) return res;
        
        int m = updates.length;
        
        for(int i = 0; i<m; i++){
            int s = updates[i][0];
            int e = updates[i][1];
            int inc = updates[i][2];
            for(int j = s; j<=e; j++){
                res[j]+=inc;
            }
        }
        
        return res;
    }
}
