package leetcode.conquer.sol.recursion;

/*
 * This code is referring to the sol below:
 * https://leetcode.com/problems/android-unlock-patterns/solution/
 * where the time complexity is o(n*n!) with space complexity of o(n) for the n is the max length
 */
public class AndroidUnlockPatterns {
	public AndroidUnlockPatterns() {}
	
	 private boolean[] used = new boolean[9];
	    
	    public int numberOfPatterns(int m, int n) {
	        if(m == 0 || n == 0) return 0;
	        int res = 0;
	        for(int i=m;i<=n;i++){
	            res+=calPattern(-1,i);
	            used =new boolean[9];
	        }
	        
	        return res;
	    }
	    
	    private boolean isValid(int pos, int last){
	        if(used[pos]) return false;
	        
	        if(last == -1) return true;
	        
	        if((last + pos) % 2 == 1) return true;
	        
	        int mid = (last+pos)/2;
	        if(mid == 4) return used[mid];
	        
	        if ((pos%3 != last%3) && (pos/3 != last/3)) {
	            return true;
	        }
	        return used[mid];
	    }
	    
	    //time complexity of this method to find one pattern is o(n!)
	    private int calPattern(int last, int len){
	        if(len == 0) return 1;
	        int sum = 0;
	        for(int i=0;i<9;i++){
	            if(isValid(i,last)){
	                used[i] = true;
	                sum+=calPattern(i,len-1);
	                used[i] =false;
	            }
	        }
	        return sum;
	    }
}
