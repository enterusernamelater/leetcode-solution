package leetcode.conquer.sol.recursion;

/*
 *  use recursion to first count the increasing order and decreasing order
 */
public class CountNumberOfTeams {
	public CountNumberOfTeams() {}
	
    private int count = 0;
    public int numTeams(int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        helper(arr,Integer.MIN_VALUE,0,0,true);
        helper(arr,Integer.MAX_VALUE,0,0,false);
        return count;
    }
    
    private void helper(int[] arr, int prev, int cur, int start,boolean one){
        if(cur == 3){
            count++;
            return;
        }
        
        for(int i = start;i<arr.length;i++){
            if(one){
                if(arr[i] < prev) continue;
                helper(arr,arr[i],cur+1,i+1,one);
            }else{
                if(arr[i] > prev) continue;
                helper(arr,arr[i],cur+1,i+1,one);
            }
        }
    }
}
