package leetcode.conquer.sol.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * using binary search to find the dup ones and store them into an array
 * the Time O(n2*n1*log(n1)) Space O(n)
 */
public class IntersectionOfTwoArrays {
	
	public IntersectionOfTwoArrays() {}
	
	public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length ==0) return new int[0];
        
        if(nums1.length<nums2.length) return intersection(nums2,nums1);
        
        Set<Integer> set = new HashSet<>();
       
        Arrays.sort(nums1);
        
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])) continue;
            if(binarySearch(nums1,nums2[i]) != -1) set.add(nums2[i]);
        }
        
        int[] res = new int[set.size()];
        int len = 0;
        for(Integer val : set){
            res[len++] = val;
        }
        
        return res;
    }
    
    private int binarySearch(int[] arr, int val){
            int l = 0;
            int r = arr.length-1;
            
            while(l<r){
                int mid = (r+l)/2;
                if(arr[mid] == val){
                    return val;
                }
                
                if(arr[mid] > val){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
        
        return arr[l] == val? val : -1;
    }
}
