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
}
