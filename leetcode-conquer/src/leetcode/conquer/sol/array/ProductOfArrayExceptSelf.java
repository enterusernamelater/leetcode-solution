
package leetcode.conquer.sol.array;

/*
 * a pure logic solution that you first traverse all the way forward to get the frist half of the product
 * then you traverse all the way back to the the second half of the product
 * the code is actually pretty self explanatory
 * Time O(n)
 * Space Constant 
 */
public class ProductOfArrayExceptSelf {
	public ProductOfArrayExceptSelf() {}
	
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 2) return nums;
        int product = 1;  
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i=1;i<nums.length;i++){
            product *= nums[i-1];
            res[i] = product;
        }
        
        product = 1;
        for(int i=nums.length-2;i>=0;i--){
            product *= nums[i+1];
            res[i] *= product;
        }
        return res;
    }
    
    public int[] productExceptSelfMySol(int[] nums) {
        int[] p1 = new int[nums.length];
        int[] p2 = new int[nums.length];
        
        int prev1=1,prev2=1;
        for(int i=0,j=nums.length-1;i<nums.length &&j>=0;i++,j--){
            p1[i] = prev1 * nums[i];
            prev1 = p1[i];
            p2[j] = prev2 *nums[j];
            prev2 = p2[j];
        }
        
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int val1 = i-1<0? 1 : p1[i-1];
            int val2 = i+1==nums.length? 1 : p2[i+1];
            res[i] = val1 * val2;
        }
        
        return res;
    }
}
