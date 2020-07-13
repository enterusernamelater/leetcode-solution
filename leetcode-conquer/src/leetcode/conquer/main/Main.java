package leetcode.conquer.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.conquer.sol.array.OneSwapArray;

/*
 * a class where I test my shit :)
 */
public class Main {
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>() {
			private static final long serialVersionUID = 1L;
		{
			add(Arrays.asList(1,3,5,6,9));
			add(new ArrayList<>());
			add(Arrays.asList(2,6,8,9,10));
		}};
	    
		OneSwapArray sol = new OneSwapArray();
		System.out.println(sol.oneSwapArray(new int[] {1,5,5,3,3,7}));
	}


	public static int findDuplicate(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			while(nums[i]-1 != i) {
				if(nums[nums[i]-1] == nums[i]) return nums[i];
				int tmp1 = nums[i];
				int tmp2 = nums[nums[i]-1];
				nums[i] = tmp2;
				nums[tmp1-1] = tmp1;
			}
		}
		
		return -1;
	}
	
	public static boolean canSchedule(int[][] scheduled, int[] schedule) {
		if(scheduled == null || scheduled.length==0) return true;
		Arrays.sort(scheduled,(a,b)->a[0]-b[0]);//the schedule is sorted 

		int start = schedule[0];
		int duration = schedule[1];
		int end = start+duration;
		if(end <= scheduled[0][0]) return true; //the case when schedule can be place in the beginning of scheduled
		if(start >= scheduled[scheduled.length-1][0] + scheduled[scheduled.length-1][1]) return true; // the case when schedule can be place in the end of the scheduled

		for(int i=1;i<scheduled.length;i++){
		int[] time1 = scheduled[i-1];
		int[] time2 = scheduled[i];
			if(start >= time1[0] + time1[1] && end<= time2[0]) return true;	
		}

		return false;
		}


	
	public static int[][] helper(int n){
		int[][] m = new int[n][n];
		
		int count=1;
		for(int i=0;i<n;i++) {
		
			//top
			for(int j=i;j<n-i;j++) m[i][j] = count++;
			//right
			for(int j=i+1;j<n-i;j++) m[j][n-i-1] = count++;
			//bottom
			for(int j=n-i-2;j>=i;j--) {
				m[n-i-1][j] = count++;
			}
			//left
			for(int j=n-i-2;j>i;j--) m[j][i] = count++;
		}
		
		return m;
	}
}
