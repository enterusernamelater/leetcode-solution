



package leetcode.conquer.main;

import java.util.Arrays;

import leetcode.conquer.sol.design.UndergroundSystem;

/*
 * a class where I test my shit :)
 */
public class Main {
	public static void main(String[] args) {
		UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);
		undergroundSystem.checkOut(27, "Waterloo", 20);
		undergroundSystem.checkOut(32, "Cambridge", 22);
		undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
		undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
		undergroundSystem.checkIn(10, "Leyton", 24);
		undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0
		undergroundSystem.checkOut(10, "Waterloo", 38);
		undergroundSystem.getAverageTime("Leyton", "Waterloo"); 
		
		char a = 'a';
		char b = 'b';
		String str = "abc";
		System.out.print("hello" + str.substring(str.length(), str.length()));
		
		int[] arr = new int[] {1,3,4,7};
		System.out.println(Arrays.binarySearch(arr, 0,4,6));
	}
}
