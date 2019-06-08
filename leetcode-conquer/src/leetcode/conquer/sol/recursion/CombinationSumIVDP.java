package leetcode.conquer.sol.recursion;
/*
 * a dp solution that finds each target's difference and when the final target comes
 * when just add all the smaller target records.
 * time o(n*k), space o(k)
 */
public class CombinationSumIVDP {
	
	public CombinationSumIVDP() {}
	
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target == 0) return 0;
        int[] arr = new int[target+1];
        arr[0]=1;
        for(int i=1;i<=target;i++)
            for(int num : nums){
                if(i-num >= 0){
                    arr[i]+=arr[i-num];           
            }
        }
        return arr[target];
    }
}
