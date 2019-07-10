package leetcode.conquer.sol.array;

/*
 * two pointers from left and right
 * if one value is smaller than the another increment 
 * the smaller val pointer as our work here is done because 
 * the max value for this pair of left and right is found.
 * if you increment the bigger side, the area will always be smaller
 * Time O(n) Space O(1)
 */
public class ContainerWithMostWater {
	public ContainerWithMostWater() {}
	
    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left <= right){
            if(height[left] < height[right]){
                res = Math.max(res, height[left]*(right-left));
                left++;
            }else{
                res = Math.max(res, height[right]*(right-left));
                right--;
            }
        }
        
        return res;
    }
}
