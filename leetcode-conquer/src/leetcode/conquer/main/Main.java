package leetcode.conquer.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move"]
[[3,3,[[0,1],[0,2],[1,2],[2,2],[2,1],[2,0],[1,0]]],["R"],["R"],["D"],["D"],["L"],["L"],["U"],["U"],["R"],["R"],["D"],["D"],["L"],["L"],["U"],["R"],["U"],["L"],["D"]]
 */
public class Main {
	public static void main(String[] argv) 
    { 
  
        // Creating object of Set 
        Set<String> arrset1 = new HashSet<String>(); 
  
        // Populating arrset1 
        arrset1.add("A"); 
        arrset1.add("B"); 
        arrset1.add("C"); 
        arrset1.add("D"); 
        arrset1.add("E"); 
  
        // print arrset1 
        System.out.println("First Set: "
                           + arrset1); 
  
        // Creating another object of Set 
        Set<String> arrset2 = new HashSet<String>(); 
  
        // Populating arrset2
        arrset2.add("E"); 
        arrset2.add("B"); 
        arrset2.add("A"); 
        arrset2.add("C"); 
        arrset2.add("D"); 
  
        // print arrset2 
        System.out.println("Second Set: "
                           + arrset2); 
  
        // comparing first Set to another 
        // using equals() method 
        boolean value = arrset1.equals(arrset2); 
  
        // print the value 
        System.out.println("Are both set equal? "
                           + value); 
        
        int[][] arr = new int[][] {{1,2},{3,4}};
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        
    } 
}
