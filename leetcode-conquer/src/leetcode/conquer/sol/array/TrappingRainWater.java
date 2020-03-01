package leetcode.conquer.sol.array;

/*
 * see explantion below, basically keep tracks the left max and right max
 * while doing so add the differences between the maxes and the current index val to the result if the current index 
 * is less than the max, the if statements ensures we have closure on the oppsite side therefore adding the difference
 * to the result is safe and the water will not leak
 * Time complexity O(n)
 * Space constant 
 */
public class TrappingRainWater {
	public TrappingRainWater() {}
	
	public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length-1;
        int lmax = 0;
        int rmax = 0;
        int res = 0;
        while(l<r){
            //this if ensures we have a closure on the other side. 
            if(height[l]<height[r]){
                lmax = Math.max(lmax,height[l]);
                //if is smaller than lmax we know now we have a bucket. 
                //if a new max is find, there is no bucket on the left we simply update max
                //result will not update because lmax-lmax = 0;
                //as the if statement height[l]<height[r] we will for sure have a closure of heihgt[r]
                //so finding the difference between lmax-height[l] is always safe for index l; 
                //note that the r bar will always be the maxium height in this interval until a larger l bar is found then
                //this process switches.
                res +=(lmax-height[l]);
                l++;
            }else{
                //same logic for the right side applies as above
                rmax = Math.max(rmax,height[r]);
                res+= (rmax-height[r]);
                r--;
            }
        }
        
        return res;
    }
}
