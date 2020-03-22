package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.List;
//O(n^2) solution use array to do the shift
public class CreateTargetArrayInTheGivenOrder {
	public CreateTargetArrayInTheGivenOrder() {}
	
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(index[i],nums[i]);
        }
        
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length;i++) res[i] = list.get(i);
        return res;
    }
}
