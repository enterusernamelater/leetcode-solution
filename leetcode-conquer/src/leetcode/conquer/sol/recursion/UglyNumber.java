package leetcode.conquer.sol.recursion;

/*
 * This solution is very similar to Factor Combinations. only difference is that instead we finding the potential factors from 
 * 1...n the factors are given we just have to know if the given factors can form the given number
 * 
 */
public class UglyNumber {
	public UglyNumber() {}
	
    public boolean isUgly(int num) {
        int[] arr = new int[]{2,3,5};
        return helper(num,arr,0);
    }
    
    private boolean helper(int n, int[] arr,int index){
        if(n == 1) return true;
        if(n<1) return false;
        
        for(int i=index;i<arr.length;i++){
            if(n%arr[i] != 0) continue;
            if(helper(n/arr[i],arr,i)) return true;
        }
        
        return false;
    }
}
