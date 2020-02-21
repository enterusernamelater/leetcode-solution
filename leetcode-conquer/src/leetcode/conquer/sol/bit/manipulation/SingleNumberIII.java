package leetcode.conquer.sol.bit.manipulation;

/*
 * See comments for explanation
 * this solution is from the link below:
 * https://www.youtube.com/watch?v=kOMJAZ0t_F4
 * Time O(n) Space constant 
 */
public class SingleNumberIII {
	public SingleNumberIII() {}
	
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        
        //first find the xor for all we name it x
        int x = 0;
        for(int num : nums) x^=num;
        //use this formula to find the first different bit between a and b where a and b are the two
        //elements that appeared only once
        //formula: x & x-1's compliment;
        x &=(~(x-1));
        
        //once we found (a,b)'s different bit we group all numbers by the different bit x.
        //because all other pairs are the same, so the two different ones will be group to different groups
        //now we just have to xor to find the final result
        
        int[] res = new int[2];
        for(int num : nums){
            if((num & x) == 0){
                res[1] ^=num; 
                // all other non a ,b numbers will result to 0 because of the xor, 
                //only ones left are the number of the 1 bit different 
                //and the number that is different from the 1 bit different, in this case num & x is 0
            }else{
                res[0] ^= num;
            }
        }
        
        return res;
    }
}
