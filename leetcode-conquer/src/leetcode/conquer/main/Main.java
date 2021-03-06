package leetcode.conquer.main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import leetcode.conquer.sol.dp.DecodeWaysII;

/*
 * a class where I test my shit :)
 */
public class Main {
	public static void main(String[] args) {
//		int[] arr = {0, 1, 0, 1, 1, 0, 0, 1};
//		System.out.println("0: 01011001");
//		StringBuilder sb = new StringBuilder();
//		for(int j=1;j<100;j++) {
//			int[] newArr = new int[8];
//			sb.append(j);sb.append(": ");
//			for(int i=0;i<8;i++) {
//				if(i-1<0 || i+1 ==8) {
//					sb.append(0);
//					newArr[i] = 0;
//				}else {
//					if(arr[i-1] == arr[i+1]) {
//						newArr[i] = 1;
//						sb.append(1);
//					}else {
//						sb.append(0);
//						newArr[i] = 0;
//					}
//				}
//			}
//			System.out.println(sb.toString());
//			sb.setLength(0);
//			arr = newArr;
//			
//		}
//		Map<String,Map> map = new HashMap<>();
//		int b = 1;
//		double a = b;
//		//PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> (b-a));
//		String str = "/a/b/c/d/e";
//		String[] strArr = str.split("/");
//		Queue<Integer> q = new LinkedList<>();
//		
//		int number = 1 << 33;
//		//number >>=1;
//		DecodeWaysII sol = new DecodeWaysII();
//		System.out.println(sol.concatenatedBinary(100000));
//		List<Integer> list = new ArrayList<>();
//		list.stream().mapToInt(Integer :: intValue).toArray();
//		String value = "";
//		
//		Stream.of(value.toCharArray()).map(i->String.valueOf(i)).collect(Collectors.toList());

		List<String> strings = new ArrayList<>();
		
		Collections.sort(strings,(a,b)->(a.compareTo(b)));

	}


	public static int findDuplicate(int[] nums) {
	    PriorityQueue<Double> high = new PriorityQueue<>((a,b) -> a<b? 1:-1);
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
