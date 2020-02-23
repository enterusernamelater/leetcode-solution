package leetcode.conquer.sol.math;

/*
 * the max of the given num is 10^9 so we only need to find the product max to 31623 which is the root of 10^9
 * then we just follow the if cases
 * Time constant
 * Space constant
 */
public class ClosestDivisors {
	public ClosestDivisors() {}
	
    public int[] closestDivisors(int num) {    
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        //root of 10^9
        for(int i=1;i<=31623;i++){
            if(i*i - num == 2 || i*i - num == 1){
                return new int[]{i,i};
            }
            int a = num/i;
            
            if(a*i - num == 2 || a*i - num == 1){
                if(diff > Math.abs(a-i)){
                    res[0] = a;
                    res[1] = i;
                    diff= Math.abs(a-i);
                }
            }else if((a+1)*i - num == 2 || (a+1)*i - num == 1){
                if(diff > Math.abs(a-i)){
                    res[0] = a+1;
                    res[1] = i;
                    diff = Math.abs(a-i);
                }
            }
        }
        
        return res;
    }
}
