package leetcode.conquer.sol.array;

/*
 * make a copy of nums1 up to m length
 * and perform merge sort on the copy and nums2 using the original nums1 as the container.
 * Time O(N)
 * Space O(n)
 */
public class MergeSortedArray {
	public MergeSortedArray() {}
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for(int i=0;i<m;i++) arr[i] = nums1[i];
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(arr[i] > nums2[j]){
                nums1[i+j] = nums2[j++];
            }else{
                nums1[i+j] = arr[i++];
            }
        }
        
        while(i<m) nums1[i+j] = arr[i++];
        while(j<n) nums1[i+j] = nums2[j++];
    }
}
